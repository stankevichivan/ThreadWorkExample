package com.stankevich.threads;

import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) {
        Foo foo = new Foo();
        var executorService = Executors.newFixedThreadPool(3);
        executorService.execute(foo::second);
        executorService.execute(foo::third);
        executorService.execute(foo::first);
        executorService.shutdown();
    }
}