package cn.raxcl.basic.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author D30100_chenlong
 * date 2022/8/4 17:34
 */
public class AtomicIntegerTest {
    private AtomicInteger count = new AtomicInteger();
    // 使用 AtomicInteger 之后， 不需要对该方法加锁，也可以实现线程安全。
    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
