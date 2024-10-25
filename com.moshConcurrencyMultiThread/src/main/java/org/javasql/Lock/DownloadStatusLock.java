package org.javasql.Lock;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatusLock {
    private int totalBytes;
    // Alternative 1: Lock
    // private Lock lock = new ReentrantLock();

    private Object totalBytesLock = new Object();



    public void increment(){
        // Alternative 2: Synchronized block
        // synchronized (this){
            // pass a monitor object : this is a bad practice
            // only one thread at a time can call the synchronized method
            // you can only synchronize one field at the same time
            // Use dedicated monitoring objects
        synchronized(totalBytesLock){
            totalBytes++;
        }


//        lock.lock();
//        try {
//            totalBytes++;
//        } finally {
//            lock.unlock();
//        }


    }

    public int getTotalBytes() {

        return totalBytes;
    }
}
