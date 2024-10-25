package org.javasql.Adders;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemoAdders {
    public static void show(){

        var status = new DownloadFileStatusAdders();


        // Start 2 threads at the same time -> cant use join

        List<Thread> threads = new ArrayList<>();
        for (var i = 0; i < 10; i++) {
            // pass the status object to each Download File task
            var thread = new Thread(new DownloadFileTaskAdders(status));
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
        System.out.println("Total Bytes " + status.getTotalBytes());


    }
}
