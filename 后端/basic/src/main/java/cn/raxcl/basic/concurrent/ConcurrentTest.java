package cn.raxcl.basic.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 并发编程测试类
 *
 * @author D30100_chenlong
 * date 2022/8/1 13:52
 */
public class ConcurrentTest {
    public static void main(String[] args) {
        ConcurrentTest concurrentTest = new ConcurrentTest();
        // 一个 main() 进程中的线程展示
        concurrentTest.threadNumTest();
    }

    private void threadNumTest() {
        // 获取 Java 线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程 ID 和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }

    }
}
