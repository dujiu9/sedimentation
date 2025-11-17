package com.dujiu.sedimentation.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dujiu
 * @date: 2025/10/19
 * SimpleDateFormat 是一个典型的非线程安全类。
 * 如果在多线程环境下共享同一个实例，会引发错误。使用 ThreadLocal 可以完美解决这个问题。
 */

public class ThreadLocalSafeDateFormat {

    private static final ThreadLocal<SimpleDateFormat> dateFormatThreadLocal =
            ThreadLocal.withInitial(() -> {
                System.out.println(Thread.currentThread().getName() + " init SimpleDateFormat");
                return new SimpleDateFormat("yyyy-MM-dd");
            });

    public static String formatDate(Date date) {
        return dateFormatThreadLocal.get().format(date);
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                String formatDate = formatDate(new Date());
                System.out.println(Thread.currentThread().getName() + "formatDate: " + formatDate);
            });
        }

        executor.shutdown();
    }
}
