package com.example.thread.util;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;

public class TheadPoolUtil {


    private static ThreadPoolExecutor poolSubmit = null;
    private static final Object lock = new Object();


    /**
     * 基于线程安全的线程池
     *
     * @return
     */
    public static ThreadPoolExecutor poolSubmit() {
        ThreadFactory factory = new CustomizableThreadFactory("Thread-Pool-");
        if (poolSubmit == null || poolSubmit.isShutdown()) {
            synchronized (lock) {
                if (poolSubmit == null || poolSubmit.isShutdown()) {
                    poolSubmit = new ThreadPoolExecutor(20, 100,
                            60L, TimeUnit.SECONDS,
                            new ArrayBlockingQueue(200), factory);
                }
            }
        }
        return poolSubmit;
    }


}
