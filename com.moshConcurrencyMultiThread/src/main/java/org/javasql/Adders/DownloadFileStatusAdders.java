package org.javasql.Adders;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class DownloadFileStatusAdders {
    private LongAdder totalBytes = new LongAdder() ;

    public void increment(){
        totalBytes.increment();
    }

    public int getTotalBytes() {
        return totalBytes.intValue();
    }

}
