package com.example.quartzspringboot.bootquartz;

import org.quartz.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author c-long.chan
 * @date 2022/2/14 21:41
 */
@Component
public class StartApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private final Scheduler scheduler;

    public StartApplicationListener(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        TriggerKey triggerKey = TriggerKey.triggerKey("trigger1","group1");
        try {
            Trigger trigger = scheduler.getTrigger(triggerKey);
            if (trigger == null){
                trigger = TriggerBuilder.newTrigger()
                        .withIdentity(triggerKey)
                        .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                        .startNow()
                        .build();
                JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
                        .withIdentity("job1","group1")
                        .build();
                scheduler.scheduleJob(jobDetail,trigger);
                scheduler.start();
            }

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
