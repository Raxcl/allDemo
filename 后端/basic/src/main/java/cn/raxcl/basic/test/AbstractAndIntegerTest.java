package cn.raxcl.basic.test;

/**
 * @author dragon
 * @date 2022/11/17 21:41
 */
public class AbstractAndIntegerTest extends AbstractTest implements IntegerTest {
    public static void main(String[] args) {
        AbstractAndIntegerTest abstractAndIntegerTest = new AbstractAndIntegerTest();
        abstractAndIntegerTest.ss(1);
        abstractAndIntegerTest.ss2(1);
        abstractAndIntegerTest.test();
        abstractAndIntegerTest.test2();
    }

    @Override
    public int methodA() {
        return 0;
    }

    @Override
    public void ss(int x) {
        IntegerTest.super.ss(x);
    }

    @Override
    public void ss2(int x) {
        IntegerTest.super.ss2(x);
    }

    @Override
    public void test11() {

    }
}
