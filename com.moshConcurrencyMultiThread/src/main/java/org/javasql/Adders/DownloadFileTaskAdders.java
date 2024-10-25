package org.javasql.Adders;

public class DownloadFileTaskAdders implements Runnable{
    private final DownloadFileStatusAdders status;

    public DownloadFileTaskAdders(DownloadFileStatusAdders status) {
        this.status = status;
    }

    @Override
    public void run() {
        //each file is 100 bytes
        for(var i = 0 ; i< 1000; i++){
            if(Thread.currentThread().isInterrupted())
                return;
            //System.out.println("Downloading byte " + i);
            status.increment();
        }

        System.out.println("Download finished" + Thread.currentThread().getName());

    }

}
