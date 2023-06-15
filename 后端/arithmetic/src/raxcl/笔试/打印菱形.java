package raxcl.笔试;

import java.util.ArrayList;
import java.util.List;

/**
 * @author D30100_chenlong
 * @date 2023/3/18 0:53
 */
public class 打印菱形 {
    public static void main(String[] args) {
        System.out.println("请输入N的值：");
        int n = 4;
        if (n < 0) {
            System.out.println("请输入大于零的整数！");
        } else {
            //上半部分
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= 2 * i - 1; k++) {
                    System.out.print("*");
                }
                System.out.println("");
            }
            //下半部分
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(" ");
                }
                for (int k = 2 * (n - i) - 1; k > 0; k--) {
                    System.out.print("*");
                }
                System.out.println("");
            }
        }
    }
}
