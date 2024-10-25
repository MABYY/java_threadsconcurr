package org.javasql.VolatilevsSync;

// Volatile vs Sync:
// Sync prevents multiple threads from
// updating a var at the same time

// Volatile keyword notifies the rest od the threads when a
// var is changed

import org.javasql.Lock.DownloadFileLock;
import org.javasql.Lock.DownloadStatusLock;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemoVolatile {
    public static void show() {

        // Sync KW

//        var status = new DownloadStatusLock();
//        List<Thread> threads = new ArrayList<>();
//        // Stat ten threads
//        for (var i = 0; i < 2; i++) {
//            var thread = new Thread(new DownloadFileLock(status));
//            thread.start();
//
//            // Join Treads
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            };
//
//            System.out.println("File is ready to be scanned");
//
//        }

        // Volatile KW

        var status = new DownloadStatusVolatile();

        var thread1 = new Thread(new DownloadFileVolatile(status));

        // Pass a lambda expression to represent the runnable object
        var thread2 = new Thread(() ->{
            while (!status.isDone()){ }// wait until the download is done
            System.out.println(status.getTotalBytes());
        });

        /// start the threads
        thread1.start();
        thread2.start();
    }
}
