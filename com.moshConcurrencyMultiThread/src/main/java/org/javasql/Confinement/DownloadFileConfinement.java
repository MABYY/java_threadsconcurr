package org.javasql.Confinement;

import org.javasql.DownloadStatus;

public class DownloadFileConfinement implements Runnable{

    // Each thread has is ow status object
    private DownloadStatus status;

    public DownloadFileConfinement() {
        this.status = new DownloadStatus();
    }


    @Override
    public void run() {
        System.out.println("Downloading file Confinement - new thread");

        //each file is 100 bytes
        for(var i = 0 ; i< 1000; i++){
            if(Thread.currentThread().isInterrupted())
                return;
            //System.out.println("Downloading byte " + i);
            status.increment();
        };
        System.out.println("Download finished" + Thread.currentThread().getName());
    };

    public DownloadStatus getStatus() {
        return status;
    }
};
