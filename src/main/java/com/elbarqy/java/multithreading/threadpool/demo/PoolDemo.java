package com.elbarqy.java.multithreading.threadpool.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolDemo {
    public static void main(String[] args) {
        new PoolDemo().run();
    }

    PoolDemo() {
    }

    void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println("started " + Thread.currentThread().getName());
                try {
                    Thread.sleep(5L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
        while(!executorService.isTerminated()){
            System.out.println("Still processing");
        }
        System.out.println("DONE");
    }
}
