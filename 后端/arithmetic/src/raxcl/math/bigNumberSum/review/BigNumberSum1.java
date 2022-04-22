package raxcl.math.bigNumberSum.review;

/**
 * 大整数求和1
 *
 * @author D30100_chenlong
 * @date 2022/4/19 15:27
 */
public class BigNumberSum1 {
    public static void main(String[] args) {
        System.out.println(bigNumberSum("426709752318", "95481253129"));
    }

    private static String bigNumberSum(String numberA, String numberB) {
        int max = Math.max(numberA.length(), numberB.length());
        int[] arrayA = new int[max+1];
        int[] arrayB = new int[max+1];
        //翻转，各位在前
        for (int i = 0; i < numberA.length(); i++) {
            arrayA[i] =  numberA.charAt(numberA.length()-1-i) - '0';
        }
        for (int i = 0; i < numberB.length(); i++) {
            arrayB[i] =  numberB.charAt(numberB.length()-1-i) - '0';
        }
        //相加
        int[] result = new int[max+1];
        for (int i = 0; i < result.length; i++) {
            int num = arrayA[i]+arrayB[i];
            if (num>9){
                result[i+1] +=1;
                num = num%10;
            }
            result[i] +=num;
        }
        //如果最后不进位，最后一位就是0，需要去除
        int endIndex = result.length-1;
        if (result[endIndex]==0){
            endIndex--;
        }
        //翻转结果
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <=endIndex; i++) {
            stringBuilder.append(result[endIndex-i]);
        }
        return stringBuilder.toString();
    }

}
