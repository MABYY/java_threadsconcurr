package org.javasql.VolatilevsSync;

public class DownloadFileVolatile implements Runnable{

    private final DownloadStatusVolatile status;

    public DownloadFileVolatile(DownloadStatusVolatile status) {
        this.status = status;
    }

//    @Override
//    public void run() {
//        //each file is 100 bytes
//        for(var i = 0 ; i< 1000; i++){
//            if(Thread.currentThread().isInterrupted())
//                return;
//            //System.out.println("Downloading byte " + i);
//            status.increment();
//        }
//
//        System.out.println("Download finished" + Thread.currentThread().getName());
//
//    }

    // Volatile KW
    @Override
    public void run() {
        //each file is 100 bytes
        for(var i = 0 ; i< 1000; i++){
            if(Thread.currentThread().isInterrupted())
                return;
            //System.out.println("Downloading byte " + i);
            status.increment();
        }

        status.done();
        System.out.println("Download finished" + Thread.currentThread().getName());

    }
}
