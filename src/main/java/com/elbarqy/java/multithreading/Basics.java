package com.elbarqy.java.multithreading;


public class Basics {
    public static void main(String[] args)  {
        Thread myThread = new Thread(new MyRunnable());
        //Anonymous class
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("my anonymous thread");
            System.out.println("anonymous has finished");
        };
        Thread secondThread = new Thread(runnable);
        secondThread.start();
        myThread.start();
        myThread.setDaemon(true);
        try{
            myThread.join();
        }catch (InterruptedException  e){
            e.printStackTrace();
        }
    }

    static class MyRunnable implements Runnable {
        //On Ram
        //local variables are stored on the stack
        //common variables are stored on the heap
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println("MyThread is running");
            System.out.println("MyThread has finished");
        }
    }
}
