package org.javasql.WaitNotify;

import org.javasql.VolatilevsSync.DownloadFileVolatile;
import org.javasql.VolatilevsSync.DownloadStatusVolatile;

// Thread waits until a condition becomes true

public class ThreadDemoWaitNot {
    public static void show() {

        // Volatile KW

        var status = new DownloadStatusVolatile();

        var thread1 = new Thread(new DownloadFileVolatile(status));

        // Pass a lambda expression to represent the runnable object
        var thread2 = new Thread(() ->{

            synchronized (status){
                try {
                    status.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            // while (!status.isDone()){ }
            // wait until the download is done
            // PROBLEM => this looses CPU cycles
            // put the thread to sleep
            // until another thread wakes it up

            System.out.println(status.getTotalBytes());
        });

        /// start the threads

        thread1.start();
        thread2.start();
    }
}
