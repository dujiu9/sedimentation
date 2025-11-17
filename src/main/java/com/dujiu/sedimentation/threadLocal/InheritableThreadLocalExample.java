package com.dujiu.sedimentation.threadLocal;

/**
 * @author dujiu
 * @date: 2025/10/19
 */
public class InheritableThreadLocalExample {

    private static InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set(" Value from Main Thread");
        System.out.println(Thread.currentThread().getName() + " get value: " + threadLocal.get());

        // 创建一个子线程
        Thread childThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " get value: " + threadLocal.get());
            threadLocal.set("Value modified in Child Thread");
            System.out.println(Thread.currentThread().getName() + " get modified value: " + threadLocal.get());
        }, "childThread");

        childThread.start();
        childThread.join();

        System.out.println(Thread.currentThread().getName() + " final get value: " + threadLocal.get());
    }
}
