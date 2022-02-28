package pool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author c-long.chan
 * @date 2022/2/9 18:54
 */
public class ScheduleThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduleThreadThreadPool = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < 2; i++) {
            scheduleThreadThreadPool.scheduleAtFixedRate(new Task("task-"+i),0,10, TimeUnit.SECONDS);
        }
    }
}


class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("name=" + name + ",startTime=" + new Date());
            Thread.sleep(3000);
            System.out.println("name=" + name + ",endTime=" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
