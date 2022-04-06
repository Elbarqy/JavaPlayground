package com.elbarqy.java.multithreading.sync.sharedMonitorObj;

public class SharedMonitorObjectDemo {
    public static void main(String[] args) {
        Object monitor1 = new Object();
        SharedMonitorObject smo1 = new SharedMonitorObject(monitor1);
        SharedMonitorObject smo2 = new SharedMonitorObject(monitor1);

        Object monitor2 = new Object();

        SharedMonitorObject smo3 = new SharedMonitorObject(monitor2);
        smo3.inCounter();
    }

}
