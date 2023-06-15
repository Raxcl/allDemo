package raxcl.od;

import java.util.Scanner;

/**
 * @author D30100_chenlong
 * @date 2023/2/20 21:06
 */
public class 汽水瓶 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /**
         * 处理每行
         *  递归是否可行? int sum =0;
         *      81  不断除以3
         */
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int num = in.nextInt();
            if (num == 0) {
                break;
            }
            int sum = 0;
            while(num>=3) {
                sum += num/3;
                num = num % 3 + num/3;
            }
            if(num == 2) sum++;
            System.out.println(sum);
        }
    }
}
