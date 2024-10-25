package org.javasql.Confinement;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemoConfinement {
    public static void show(){

        // Start 2 threads at the same time -> cant use join

        List<Thread> threads = new ArrayList<>();
        List<DownloadFileConfinement> tasks = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var task = new DownloadFileConfinement();
            tasks.add(task);

            // pass the status object to each Download File task
            var thread = new Thread(task);
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
        // use streams API to combine
        var totalBytes = tasks.stream()
                        .map(t ->t.getStatus().getTotalBytes())
                        .reduce(0, Integer::sum);
                        //.reduce(0,(a,b)-> a+b);
        System.out.println("Total Bytes " + totalBytes);


    }
}
