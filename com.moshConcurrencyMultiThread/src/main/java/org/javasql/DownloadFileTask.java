package org.javasql;

public class DownloadFileTask  implements Runnable{

    // Simulate downloading a file
    @Override
    public void run() {
        System.out.println("Thread Demo " +  Thread.currentThread().getName());
        System.out.println("Downloading file - new thread");

        // Suspend the thread a few seconds
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Download finished" + Thread.currentThread().getName());

        // Interrupt Thread
//        for(var i = 0 ; i< Integer.MAX_VALUE; i++){
//            if(Thread.currentThread().isInterrupted())
//                return;
//            System.out.println("Downloading byte " + i);
//        }


    }
//    private DownloadStatus status;
//
//    public DownloadFileTask(DownloadStatus status) {
//        this.status = status;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("Downloading a file: " + Thread.currentThread().getName());
//
//        for (var i = 0; i < 10_000; i++) {
//            if (Thread.currentThread().isInterrupted()) return;
//            status.incrementTotalBytes();
//        }
//
//        status.done();
//
//        System.out.println("Download complete: " + Thread.currentThread().getName());
//    }
}
