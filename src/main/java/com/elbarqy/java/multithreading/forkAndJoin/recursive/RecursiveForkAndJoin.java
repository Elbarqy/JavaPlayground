package com.elbarqy.java.multithreading.forkAndJoin.recursive;

import com.elbarqy.java.multithreading.forkAndJoin.AppleTree;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class RecursiveForkAndJoin {
    public static void main(String[] args) {
        AppleTree[] appleTrees = AppleTree.newTreeGarden(12);
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        PickFruitTask task = new PickFruitTask(appleTrees, 0, appleTrees.length - 1);
        int result = (int) forkJoinPool.invoke(task);
        System.out.println("result 🤩 " + result);
    }

    public static class PickFruitTask extends RecursiveTask<Integer> {
        private final AppleTree[] appleTrees;
        private final int startInclusive;
        private final int endExclusive;
        private final int taskThreshold = 4;

        public PickFruitTask(AppleTree[] appleTrees, int startInclusive, int endExclusive) {
            this.appleTrees = appleTrees;
            this.startInclusive = startInclusive;
            this.endExclusive = endExclusive;
        }

        protected Integer doCompute() {
            return IntStream.rangeClosed(startInclusive, endExclusive)
                    .map(i -> appleTrees[i].pickApples())
                    .sum();
        }

        @Override
        protected Integer compute() {
            if (endExclusive - startInclusive < taskThreshold) {
                return doCompute();
            }
            int midpoint = startInclusive + (endExclusive - startInclusive) / 2;
            PickFruitTask leftSum = new PickFruitTask(appleTrees, startInclusive, midpoint);
            PickFruitTask rightSum = new PickFruitTask(appleTrees, midpoint + 1, endExclusive);
            rightSum.fork();
            return leftSum.compute() + rightSum.join();
        }
    }
}
