package raxcl.test;

import java.util.Arrays;

/**
 * @author D30100_chenlong
 * @date 2022/6/1 11:13
 */
public class Test {
    //输出今天日期并格式化”yyyy-MM-dd”


    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int top = 0;
        int i = -1;
        while (top < n){
            i++;
            if (arr[i] != 0){
                top++;
            }else{
                top +=2;
            }
        }
        int j=n-1;
        if (top==n+1){
            arr[j]=0;
            j--;
            i--;
        }
        while (j>=0){
            arr[j] = arr[i];
            j--;
            if (arr[i]==0){
                arr[j]=arr[i];
                j--;
            }
            i--;
        }
    }

    public String test(int m) {
        for (int i = 1; i < m + 1 >> 1; i++) {
            int sum = i, temp = i;
            while (sum < m) sum += ++temp;
            if (sum == m) return "YES";
        }
        return "NO";
    }
    // 怎样的数不能相加？
    /**
     *
     * 14 偶数不能 两个相加
     *
     *
     * 9 9 >> 1 = 4 + 5 = 9
     * 11 11 >> 1 = 5 + 6 = 11
     * 13 13 >> 1 = 6 + 7 = 13
     * 15 15 >> 1 = 7 + 8 = 15
     * 17 17 >> 1 = 8 + 9 = 17
     * 19 19 >> 1 = 9 + 10 = 19
     * 21 21 >> 1 = 10 + 11 = 21
     * 结论： 奇数可以转换为 两个相加
     *
     * 偶数：
     * 32 32 / 3 = 10 + 11 + 12 = 33
     *    32 /4  = 7 + 8 + 9 + 10
     *    32 /5  = 5 + 6 + 7 + 8 + 9
     *    5 6 7 8 = 26
     *    13 = 7 6
     *    100  =  18 19 20 21 22
     *    3 5 7
     *
     */
    public String test1(int n) {
        int ans = 0; n *= 2;
        for (int k = 1; k * k < n; k++) {
            if (n % k != 0) continue;
            if ((n / k - (k - 1)) % 2 == 0) ans++;
        }
        if (ans == 0) return "NO";
        return "YES";
    }

    public static void main(String[] args) {
        Test t = new Test();
        // 536870812 能被 多少整除
//        for (int i = 2; i < 536870812; i++) {
//            if (536870812 % i == 0) System.out.println(i);
//
//        }
        String s0 = t.test1(536870812);
        String s = t.test(536870812);
        // 3947512
//        t.test2(536870812);
        System.out.println(s0);
        System.out.println(s);
    }

    // 135 个数相加
    public void test2(int m) {
        int sum = 3947512, temp = 3947512, count = 1;
        while (sum < m) {
            sum += ++temp;
            System.out.println(temp + " " + count++);
        }
    }

}
