package org.javasql;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemoRC {
    public static void show(){

        var status = new DownloadStatus();


        // Start 2 threads at the same time -> cant use join

        List<Thread>  threads = new ArrayList<>();
        for (var i = 0; i < 10; i++) {
            // pass the status objectto each Download File task
            var thread = new Thread(new DownloadFileRC(status));
            thread.start();
            threads.add(thread);
        };

        // Iterate over threads and join them

        for(var thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print the total bytes we have downloaded
        // The number changes since multiple threads compete to
        // update totalBytes
        // This is because the increment function is an atomic method

        System.out.println("Total Bytes " + status.getTotalBytes());


    }
}
