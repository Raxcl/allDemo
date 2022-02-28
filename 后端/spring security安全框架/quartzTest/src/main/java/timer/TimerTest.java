package timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author c-long.chan
 * @date 2022/2/9 10:23
 */
public class TimerTest {

    public static void main(String[] args) {
        Timer t = new Timer();//任务启动
        for (int i=0; i<2; i++){
            TimerTask task = new FooTimerTask("foo"+i);
//            t.schedule(task,new Date(),2000);//任务添加  sehdule 执行时间取决于上一个任务的结束时间   缺点： 执行时间延后
            t.scheduleAtFixedRate(task,new Date(),3000); // scheduleAtFixedRate 严格按照预设时间 缺点：由于前一个任务还在执行，超过了下一个任务的执行时间，轮到下一个任务时，由于已经超过时间了，所以会马上执行，执行时间混乱
            //单线程，任务阻塞，任务超时
        }
    }
}


class FooTimerTask extends TimerTask {

    private String name;

    public FooTimerTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("name="+name+",startTime="+new Date());
            Thread.sleep(3000);
            System.out.println("name="+name+",endTime="+new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
