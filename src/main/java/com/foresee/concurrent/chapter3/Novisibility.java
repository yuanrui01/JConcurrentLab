package main.java.com.foresee.concurrent.chapter3;

import java.util.concurrent.TimeUnit;

/**
 * @description: 验证可见性问题
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/8/12-23:46
 */
public class Novisibility {

    private static boolean ready;

    public static class ReaderThread extends Thread {
        @Override
        public void run() {
            System.out.println(currentThread().getName() + "\t ==== in");
            while(!ready) {
            }
            System.out.println(currentThread().getName() + "\t ==== out");
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ready = true;
    }
}
