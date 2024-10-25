package org.javasql.VolatilevsSync;

public class DownloadStatusVolatile {


    private int totalBytes;
    private int totaFiles;

    // dedicated monitor objects
    private Object totalBytesLock = new Object();
    private Object totalFilesLock = new Object();


    // volatile KW to solve the visibility problem
    // tell the VW to read the value from the main memory,
    // not the cache
    private  volatile boolean isDone;

    public void increment(){
        // pass monitor object
        // passing this is a bad practice
        // 'this' prevents you from updating
        // totalBytes and totalFiles at the same time
        synchronized(totalBytesLock){
            totalBytes++;
        }

    }

    public synchronized void incrementTotalFiles(){
            totaFiles++;
    }

    public  int getTotalBytes() {
        return totalBytes;
    }

    public int getTotaFiles() {
        return totaFiles;
    }

    // volatile KW

    // Use the syncronized kw of the volative access mod
    public synchronized boolean isDone() {
        return isDone;
    }

    public synchronized void done() {
        isDone = true;
    }
//    public synchronized boolean isDone() {
//        return isDone;
//    }
//
//    public synchronized void done() {
//        isDone = true;
//    }
}
