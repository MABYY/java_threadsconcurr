package org.javasql;


import org.javasql.Adders.ThreadDemoAdders;
import org.javasql.Atomic.ThreadDemoAtomic;

public class Main {
    public static void main(String[] args) {

        ThreadDemoRC.show();
        ThreadDemoAtomic.show();
        ThreadDemoAdders.show();
    }


}