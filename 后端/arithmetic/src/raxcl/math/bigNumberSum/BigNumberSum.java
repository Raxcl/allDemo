package raxcl.math.bigNumberSum;

import java.util.Arrays;

/**
 * 大整数求和
 *
 * @author D30100_chenlong
 * @date 2022/4/18 14:49
 */
public class BigNumberSum {
    public static void main(String[] args) {
        System.out.println(bigNumberSum("426709752318", "95481253129"));
    }

    private static String bigNumberSum(String a, String b) {
        int length = Math.max(a.length(),b.length());
        int[] arrayA = new int[length];
        int[] arrayB = new int[length];
        for (int i = 0; i < a.length(); i++) {
            arrayA[i] = a.charAt(a.length()-1-i) - '0';
        }
        for (int i = 0; i < b.length(); i++) {
            arrayB[i] = b.charAt(b.length()-1-i) - '0';
        }
        int[] result = new int[length+1];
        //相加
        for (int i = 0; i < result.length-1; i++) {
            int sum = arrayA[i]+arrayB[i];
            if (sum>9){
                result[i+1]++;
            }
            result[i] += sum%10;
        }
        //消除0
        int newLength = result.length;
        for (int i = result.length-1; i>=0 ; i--) {
            if(result[i] ==0){
                newLength--;
            }else{
                break;
            }
        }
        int[] newResult = new int[newLength];
        for (int i = 0; i < newLength; i++) {
            newResult[i] = result[i];
        }

        //转成string
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < newResult.length; i++) {
            stringBuilder.append(newResult[newResult.length-1-i]);
        }
        return stringBuilder.toString();
    }
}
