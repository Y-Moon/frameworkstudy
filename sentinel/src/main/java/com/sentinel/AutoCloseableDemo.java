package com.sentinel;

public class AutoCloseableDemo implements AutoCloseable{
    public static AutoCloseableDemo createDemo(){
        return new AutoCloseableDemo();
    }
    @Override
    public void close() throws Exception {
        System.out.println("close");
    }
}
