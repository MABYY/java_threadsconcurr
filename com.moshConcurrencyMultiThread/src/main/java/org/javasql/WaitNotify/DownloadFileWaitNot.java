package org.javasql.WaitNotify;

import org.javasql.VolatilevsSync.DownloadStatusVolatile;

public class DownloadFileWaitNot implements Runnable {

    private final DownloadStatusWaitNot status;

    public DownloadFileWaitNot(DownloadStatusWaitNot status) {
        this.status = status;
    }

    @Override
    public void run() {
        //each file is 100 bytes
        for(var i = 0 ; i< 1000; i++){
            if(Thread.currentThread().isInterrupted())
                return;
            status.increment();
        }

        status.done();

        // notify the other thread that
        // the state of this object has changed
        synchronized (status){
            status.notifyAll();
        }


        System.out.println("Download finished" + Thread.currentThread().getName());

    }
}
