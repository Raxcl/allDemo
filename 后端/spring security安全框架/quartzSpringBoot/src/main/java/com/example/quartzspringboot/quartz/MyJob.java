package com.example.quartzspringboot.quartz;

import org.quartz.*;

import java.util.Date;


/**
 * @author c-long.chan
 * @date 2022/2/10 10:13
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class MyJob implements Job {
    private String name;

    public void setName(String name){
        this.name = name;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        /*JobDataMap jobDetailMap = jobExecutionContext.getJobDetail().getJobDataMap();
        JobDataMap triggerMap = jobExecutionContext.getTrigger().getJobDataMap();
        JobDataMap mergeMap = jobExecutionContext.getMergedJobDataMap();
        System.out.println("jobDetailMap:"+jobDetailMap.getString("job"));
        System.out.println("triggerMap:"+triggerMap.getString("trigger"));
        System.out.println("mergeMap:"+mergeMap.getString("trigger"));
        System.out.println("name:"+name);*/

        /*System.out.println("execute:"+new Date());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

      /*  JobDataMap triggerMap = jobExecutionContext.getTrigger().getJobDataMap();
        triggerMap.put("count",triggerMap.getInt("count")+1);
        System.out.println("triggerMap count:"+triggerMap.getInt("count"));*/

        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        jobDataMap.put("count1",jobDataMap.getInt("count1")+1);
        System.out.println("jobDataMap count:"+jobDataMap.getInt("count1"));

    }
}
