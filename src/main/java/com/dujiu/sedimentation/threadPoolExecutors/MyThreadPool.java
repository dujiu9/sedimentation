package com.dujiu.sedimentation.threadPoolExecutors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author dujiu
 * @date: 2025/10/21
 */
public class MyThreadPool {

    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(2, 4, 1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), new ThrowRejectHandler(),new CustomThreadFactory("MyPool-Thread"));
        for (int i = 0; i < 5; i++) {
            myThreadPool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(Thread.currentThread().getName() + " 主线程没有被阻塞");
    }

    private final int corePoolSize;
    private final int maxPoolSize;
    private final long timeout;
    private final TimeUnit timeUnit;
    public final BlockingQueue<Runnable> blockingQueue;
    private final RejectHandler rejectHandler;
    private final CustomThreadFactory threadFactory;

    public MyThreadPool(int corePoolSize, int maxPoolSize, long timeout, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, RejectHandler rejectHandler, CustomThreadFactory threadFactory) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.blockingQueue = blockingQueue;
        this.rejectHandler = rejectHandler;
        this.threadFactory = threadFactory;
    }

    List<Thread> coreList = new ArrayList<>();
    List<Thread> supportList = new ArrayList<>();

    void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException("");
        }
        if (coreList.size() < corePoolSize) {
            Thread thread = threadFactory.newThread(new CoreThread(command));
            coreList.add(thread);
            thread.start();
            return;
        }
        if (blockingQueue.offer(command)) {
            return;
        }
        if (coreList.size() + supportList.size() < maxPoolSize) {
            Thread thread = threadFactory.newThread(new SupportThread(command));
            supportList.add(thread);
            thread.start();
            return;
        }

        rejectHandler.reject(command, this);
    }

    class CoreThread implements Runnable {
        private final Runnable firstTask;

        public CoreThread(Runnable firstTask) {
            this.firstTask = firstTask;
        }
        @Override
        public void run() {
            firstTask.run();
            while (true) {
                try {
                    Runnable command = blockingQueue.take();
                    command.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class SupportThread implements Runnable {
        private final Runnable firstTask;

        public SupportThread(Runnable firstTask) {
            this.firstTask = firstTask;
        }
        @Override
        public void run() {
            firstTask.run();
            while (true) {
                try {
                    Runnable command = blockingQueue.poll(timeout, timeUnit);
                    if (command == null) {
                        break;
                    }
                    command.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + "线程结束了！");
            supportList.remove(Thread.currentThread());
        }
    }
}
