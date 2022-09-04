package cn.raxcl.basic.concurrent.threadPool;

import java.util.Date;

/**
 * 这是一个简单的Runnable类，需要大约 5 秒钟来执行其任务。
 *
 * @author D30100_chenlong
 * date 2022/8/3 21:31
 */
public class MyRunnable implements Runnable{
    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + this.command + "======= Start. Time " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + this.command + "======= End. Time " + new Date());

    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
