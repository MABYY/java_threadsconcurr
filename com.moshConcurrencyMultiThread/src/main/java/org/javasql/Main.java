package org.javasql;


import org.javasql.Adders.ThreadDemoAdders;
import org.javasql.Atomic.ThreadDemoAtomic;
import org.javasql.CollectionsConcurrent.ThreadDemoConcColl;
import org.javasql.CollectionsSync.ThreadDemoColSync;

public class Main {
    public static void main(String[] args) {

        ThreadDemoRC.show();
        ThreadDemoAtomic.show();
        ThreadDemoAdders.show();

        ThreadDemoColSync.show();
        ThreadDemoConcColl.show();
    }


}