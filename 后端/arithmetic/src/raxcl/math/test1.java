package raxcl.math;

/**
 * @author D30100_chenlong
 * @date 2022/6/25 10:51
 */
public class test1 {
    public static void main(String[] args) {
        int n = 5;
        int mod = 7;
        int sum = 1;
        for (int i = 1; i < n; i++) {
            sum *= i;
        }
        sum %= mod;
        System.out.println(sum);
        int sum1 = 1;
        for (int i = 1; i < n; i++) {
            sum1 *= i;
            sum1 %= mod;
        }
        System.out.println(sum1);
//        int n=75;
//        double sum=1;
//        for (int i = 2; i <= n; i++) {
//            sum*=i;
//            System.out.println(i+":"+sum);
//        }
//        int s = (int)(sum%(Math.pow(10,9)+7));
//        System.out.println(sum%(Math.pow(10,9)+7));
//        System.out.println(s);
    }
}
