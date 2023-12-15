package com.foresee.future;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CFutureDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //CompletableFuture.supplyAsync 调用后是立即运行
//        List<CompletableFuture<String>> collect = integers.stream().map(i -> CompletableFuture.supplyAsync(() -> job(i))).collect(Collectors.toList());
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello");
        }).get();
        System.out.println("World!");

        Thread.sleep(5_000L);

    }

    private static String job(int i) {
        String s = "this is " + i;
        System.out.println(s);
        return s;
    }
}
