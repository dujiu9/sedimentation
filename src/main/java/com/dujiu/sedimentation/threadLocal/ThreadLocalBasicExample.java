package com.dujiu.sedimentation.threadLocal;

/**
 * @author dujiu
 * @date: 2025/10/19
 * 线程间 数据隔离：每个线程都有自己的变量副本。
 */
public class ThreadLocalBasicExample {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            threadLocal.set("thread-1");
            System.out.println(Thread.currentThread().getName() + "get value: " + threadLocal.get());
            // 为了演示隔离性，休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + "final get value: " + threadLocal.get());
            threadLocal.remove();
        }, "thread-1");

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "get value: " + threadLocal.get());

            // 为了演示隔离性，休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            threadLocal.set("thread-2");
            System.out.println(Thread.currentThread().getName() + "final get value: " + threadLocal.get());
            threadLocal.remove();
        }, "thread-2");

        thread1.start();
        thread2.start();
    }
}
