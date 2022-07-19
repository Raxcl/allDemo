package cn.raxcl.basic.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile关键字测试（测试结果：volatile关键字无法保证原子性）
 *
 * @author D30100_chenlong
 * @date 2022/6/21 15:19
 */
public class VolatileTest extends Thread{
    static volatile int increase = 0;
    static AtomicInteger aInteger = new AtomicInteger();//对照组
    static void increaseFun(){
        increase++;
        aInteger.incrementAndGet();
    }

    @Override
    public void run(){
        int i=0;
        while(i<10000){
            increaseFun();
            i++;
        }
    }

    public static void main(String[] args) {
        VolatileTest vt = new VolatileTest();
        int THREAD_NUM = 10;
        Thread[] threads = new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            threads[i] = new Thread(vt, "线程"+i);
            threads[i].start();
        }
        //idea中会返回主线程和守护线程
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println("volatile的值："+increase);
        System.out.println("AtomicInteger的值："+aInteger);
    }
}
