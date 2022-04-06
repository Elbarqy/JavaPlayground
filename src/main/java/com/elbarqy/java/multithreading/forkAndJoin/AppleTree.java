package com.elbarqy.java.multithreading.forkAndJoin;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class AppleTree {
    public static AppleTree[] newTreeGarden(int size) {
        AppleTree[] appleTrees = new AppleTree[size];
        for (int i = 0; i < size; i++) {
            appleTrees[i] = new AppleTree("🌲# " + i);
        }
        return appleTrees;
    }

    private final String treeLabel;
    private final int numberOfApples;

    public AppleTree(String treeLabel) {
        this.treeLabel = treeLabel;
        numberOfApples = 3;
    }

    public int pickApple(String workerName) {
        try {
            System.out.printf("%s started working picking 🍎 from %s\n", workerName, treeLabel);
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("%s has finished picking 🍎 from %s\n", workerName, treeLabel);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return numberOfApples;
    }

    public int pickApples() {
        return pickApple(toLabel(Thread.currentThread().getName()));
    }

    private String toLabel(String threadName) {
        HashMap<String, String> threadNameToLabel = new HashMap<>();
        threadNameToLabel.put("ForkJoinPool.commonPool-worker-1", "Alice");
        threadNameToLabel.put("ForkJoinPool.commonPool-worker-2", "Bob");
        threadNameToLabel.put("ForkJoinPool.commonPool-worker-3", "Carol");
        threadNameToLabel.put("ForkJoinPool.commonPool-worker-4", "Dan");

        return threadNameToLabel.getOrDefault(threadName, threadName);
    }
}
