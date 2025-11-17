package com.dujiu.sedimentation.threadPoolExecutors;

/**
 * @author dujiu
 * @date: 2025/10/21
 */
public class ThrowRejectHandler implements RejectHandler {
    @Override
    public void reject(Runnable RejectCommand, MyThreadPool threadPool) {
        throw new RuntimeException("阻塞队列满了!");
    }
}
