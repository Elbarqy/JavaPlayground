package com.elbarqy.java.multithreading.sync;

public class SyncDemo {
    public static void main(String[] args) {
        // The process
        SynchExchanger synchExchanger = new SynchExchanger();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchExchanger.setObject("" + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5200; i++) {
                System.out.println(synchExchanger.getObject());
            }
        });
        thread1.start();
        thread2.start();

    }
}
