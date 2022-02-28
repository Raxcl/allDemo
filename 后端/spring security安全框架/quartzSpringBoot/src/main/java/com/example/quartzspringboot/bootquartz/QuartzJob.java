package com.example.quartzspringboot.bootquartz;

import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * 定时任务
 * @author c-long.chan
 * @date 2022/2/14 20:37
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class QuartzJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            Thread.sleep(2000);
            System.out.println("调度器id为："+jobExecutionContext.getScheduler().getSchedulerInstanceId());
            System.out.println("taskname="+jobExecutionContext.getJobDetail().getKey().getName());
            System.out.println("执行时间="+new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
