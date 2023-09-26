package com.foresee;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: yuanrui
 */
public class CompletableFutureUseDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        AtomicInteger ans = new AtomicInteger(-1);
        AtomicReference<String> haha = new AtomicReference<>("dsldjjdas");
        try {
            CompletableFuture.supplyAsync(() -> {
                int i = ThreadLocalRandom.current().nextInt(10);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("1秒钟后出结果 ------ result:" + i);
                ans.set(i);
                haha.set("34231");
                return i;
            }, threadPool).whenComplete((result, e) -> {
                if (e == null)
                    System.out.println("成功出结果了！！！result: " + result);

                System.out.println(Thread.currentThread().getName());
            }).exceptionally(e -> {
                System.out.println("唉，发生异常了~~~~~~");
                return 0;
            });
        } finally {
            threadPool.shutdown();
            System.out.println(Thread.currentThread().getName());
        }

//        while ( ans.get() == -1) {}
//
//        System.out.println(haha);
    }


    private void future1() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            int i = ThreadLocalRandom.current().nextInt(10);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("1秒钟后出结果 ------ result:" + i);
            return i;
        });

        System.out.println(integerCompletableFuture.get());
    }
}
