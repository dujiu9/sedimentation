package com.dujiu.sedimentation.threadPoolExecutors;

/**
 * @author dujiu
 * @date: 2025/10/21
 */
public class DiscardRejectHandler implements RejectHandler{
    @Override
    public void reject(Runnable RejectCommand, MyThreadPool threadPool) {
        threadPool.blockingQueue.poll();
        threadPool.execute(RejectCommand);
    }
}
