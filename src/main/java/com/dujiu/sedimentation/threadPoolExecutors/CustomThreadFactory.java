package com.dujiu.sedimentation.threadPoolExecutors;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.NORM_PRIORITY;

/**
 * @author dujiu
 * @date: 2025/10/21
 */
public class CustomThreadFactory implements ThreadFactory {

    private final String threadNamePrefix;
    private final AtomicInteger threadCount = new AtomicInteger(1);

    public CustomThreadFactory(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(threadNamePrefix + "-" + threadCount.getAndIncrement());
        thread.setDaemon(false);
        thread.setPriority(NORM_PRIORITY);
        return thread;
    }
}
