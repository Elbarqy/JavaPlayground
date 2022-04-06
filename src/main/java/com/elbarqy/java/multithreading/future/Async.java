package com.elbarqy.java.multithreading.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Async {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadpool = Executors.newCachedThreadPool();
        Future<Integer> futureTask = threadpool.submit(() -> {
            int x = 1;
            for (int i = 1; i < 500; ++i) {
                x = x * 2;
            }
            return x;
        });

        while (!futureTask.isDone()) {
            System.out.println("FutureTask is not finished yet...");
        }
        long result = futureTask.get();
        System.out.println(result);
        threadpool.shutdown();
    }

}
