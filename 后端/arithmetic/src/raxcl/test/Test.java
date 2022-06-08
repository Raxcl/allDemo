package raxcl.test;

import java.util.Arrays;

/**
 * @author D30100_chenlong
 * @date 2022/6/1 11:13
 */
public class Test {
    int[] b;
    public static void main(String[] args) {
        Test test = new Test();
        test.a();
    }

    private void a() {
        int[] a = {1,2,3,4};
        b =a;
        a[0] = 9;
        b[3] = 9;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
