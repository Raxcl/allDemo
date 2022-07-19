package cn.raxcl.basic.test;

/**
 * Integer缓存测试
 *
 * @author D30100_chenlong
 * @date 2022/6/27 15:08
 */
public class IntegerCacheTest {

    public static void main(String[] args) {
        IntegerCacheTest integerCacheTest = new IntegerCacheTest();
        boolean test = integerCacheTest.test();
        System.out.println(test);
    }

    private boolean test() {
        String a="a";
        a.equals(a);
        return true;
        
    }
}
