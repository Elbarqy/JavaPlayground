package com.elbarqy.java.multithreading.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //The CompletableFuture internally uses ForkJoinPool to handle the task asynchronously. Thus, it makes our code a lot cleaner.
        CompletableFuture<Integer> completableFuture =
                CompletableFuture.supplyAsync(() -> 5)
                        .whenCompleteAsync((v, e) -> System.out.println("woo" + v.toString()));
        while (!completableFuture.isDone()) {
            System.out.println("CompletableFuture is not finished yet...");
        }
        long result = completableFuture.get();
    }
}
