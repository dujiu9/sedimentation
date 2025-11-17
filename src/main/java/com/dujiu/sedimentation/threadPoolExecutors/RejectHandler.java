package com.dujiu.sedimentation.threadPoolExecutors;

/**
 * @author dujiu
 * @date: 2025/10/21
 */
public interface RejectHandler {

    void reject(Runnable RejectCommand, MyThreadPool threadPool);
}
