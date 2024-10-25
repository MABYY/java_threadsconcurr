package org.javasql;

public class ThreadsStart {
    public static void show(){
        System.out.println("# of active threads in the current process");
        System.out.println(Thread.activeCount());
        System.out.println("# of available threads");
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
