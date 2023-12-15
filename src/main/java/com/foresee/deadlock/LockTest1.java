package com.foresee.deadlock;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * fdskfjhfds
 */
public class LockTest1 {

    private final Object objectA = new Object();
    private final Object objectB = new Object();

    public void m1() {
        synchronized (objectA) {
            System.out.println("m1 get objectA...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (objectB) {
                System.out.println("m1 get object B...");
            }
        }
    }

    public void m2() {
        synchronized (objectB) {
            System.out.println("m2 get objectB...");
            synchronized (objectA) {
                System.out.println("m2 get object A...");
            }
        }
    }

    public static void main(String[] args) {
        LockTest1 lockTest1 = new LockTest1();

//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//
//        CompletableFuture.runAsync(lockTest1::m1,executorService).whenComplete((v,e) -> {
//            if (e != null)
//                System.out.println("something wrong!");
//            else
//                System.out.println("m1 finished success~");
//        });
//        CompletableFuture.runAsync(lockTest1::m2,executorService).whenComplete((v,e) -> {
//            if (e != null)
//                System.out.println("something wrong!");
//            else
//                System.out.println("m2 finished success~");
//        });
        new Thread(lockTest1::m1).start();
        new Thread(lockTest1::m2).start();

        System.out.println("main exit~~");
//        executorService.shutdown();
    }
}
