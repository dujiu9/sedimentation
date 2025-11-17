package com.dujiu.sedimentation.threadLocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dujiu
 * @date: 2025/10/19
 */
public class TransmittableThreadLocalExample {

    private static TransmittableThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        threadLocal.set("example");

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + "get value: " + threadLocal.get());
        };

        executor.execute(TtlRunnable.get(task));

        threadLocal.set("update");
        executor.execute(TtlRunnable.get(task));
        executor.shutdown();
    }
}
