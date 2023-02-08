package cn.raxcl.basic.线程池;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

public class 线程异常demo {
    public static void main(String[] args) {
        ThreadPoolTaskExecutor executorService = buildThreadPoolTaskExecuter();
        executorService.execute(() -> sayHi("execute"));
        executorService.submit(() -> sayHi("submit"));
    }

    private static void sayHi(String name) {
        String printStr = "【thread-name :" + Thread.currentThread().getName() + ", 执行方式：" + name + "】";
        System.out.println(printStr);
        throw new RuntimeException(printStr + "我异常啦！哈哈哈！");
    }

    private static ThreadPoolTaskExecutor buildThreadPoolTaskExecuter() {
        ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
        executorService.setThreadNamePrefix("raxcl学线程池");
        executorService.setCorePoolSize(5);
        executorService.setMaxPoolSize(10);
        executorService.setQueueCapacity(1000);
        executorService.setKeepAliveSeconds(30);
        executorService.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executorService.initialize();
        return executorService;
    }
}
