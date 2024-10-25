package org.javasql.Lock;

import org.javasql.DownloadFileTask;
import org.javasql.DownloadStatus;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemoLock {
    public static void show() {

        var status = new DownloadStatusLock();

        List<Thread> threads = new ArrayList<>();
        // Stat ten threads
        for (var i = 0; i < 2; i++) {
            var thread = new Thread(new DownloadFileLock(status));
            thread.start();

            // Join Treads
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            };

            System.out.println("File is ready to be scanned");

        }
    }
}
