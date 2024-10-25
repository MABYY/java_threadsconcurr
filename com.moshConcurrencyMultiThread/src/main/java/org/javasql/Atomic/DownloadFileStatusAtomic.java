package org.javasql.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class DownloadFileStatusAtomic {
    private AtomicInteger totalBytes = new AtomicInteger();

    public void increment(){
        totalBytes.incrementAndGet();
    }

    public int getTotalBytes() {
        return totalBytes.get();
    }

}
