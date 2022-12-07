package cn.raxcl.basic.test;

/**
 * @author dragon
 * @date 2022/11/17 21:31
 */
public interface IntegerTest {
    int a = 0;
    Integer b = 0;
    int methodA();
    default void ss(int x){
        x = a;
        System.out.println(x);
    }
    default void ss2(int x){
        x = b;
        System.out.println(x);
    }
    abstract void test11();

}
