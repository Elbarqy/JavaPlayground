package com.elbarqy.java.multithreading.sync.sharedMonitorObj;

public class SharedMonitorObject {
    private final Object monitor;
    private int counter = 0;
    public SharedMonitorObject(Object mon){
        if(mon == null){
            throw new IllegalArgumentException(
                    "Monitor cannot be set to null"
            );
        }
        this.monitor = mon;
    }
    public void inCounter(){
        synchronized (monitor){
            this.counter++;
        }
    }
}
