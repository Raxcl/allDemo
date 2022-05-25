package raxcl.math.bigNumberSum.review;

import java.util.Arrays;

/**
 * 大整数相加复习5
 *
 * @author D30100_chenlong
 * @date 2022-05-18 13:35:04
 */
public class BigNumberSum5 {
    public static void main(String[] args) {
        System.out.println(bigNumberSum("426709752318", "95481253129"));
    }

    private static String bigNumberSum(String a, String b) {
        //将两数转成两数组，逆序
        int max = Math.max(a.length(),b.length());
        int[] numberA = new int[max];
        for (int i=0; i<a.length(); i++){
            numberA[i] = a.charAt(a.length()-1-i)-'0';
        }
        int[] numberB = new int[max];
        for (int i=0; i<b.length(); i++){
            numberB[i] = b.charAt(b.length()-1-i)-'0';
        }
        //定义一个结果数组，长度比最大长度多一位
        int[] result = new int[max+1];
        //相加
        for (int i=0; i<max; i++){
            int num = numberA[i]+numberB[i];
            if (num>9){
                num %= 10;
                result[i+1] +=1;
            }
            result[i] += num;
        }
        //去零
        int endIndex = result.length -1;
        if (result[endIndex]==0){
            endIndex--;
        }

        //逆序封装进StringBuild中
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = endIndex; i >= 0 ; i--) {
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();
    }
}
