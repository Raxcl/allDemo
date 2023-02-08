package cn.raxcl.basic.线程池.concurrent;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * 本地线程测试（本地变量，其他线程不可用）
 *
 * @author D30100_chenlong
 * date 2022/8/3 11:16
 */
public class ThreadLocalExample implements Runnable{
    // SimpleDateFormat 不是线程安全的，所有每个线程都要有自己独立地副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample obj = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(obj, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thead Name= " + Thread.currentThread().getName() + " default Formatter = " + formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        formatter.set(new SimpleDateFormat());
        System.out.println("Thread Name= " + Thread.currentThread().getName() + " formatter = " + formatter.get().toPattern());
    }
}
