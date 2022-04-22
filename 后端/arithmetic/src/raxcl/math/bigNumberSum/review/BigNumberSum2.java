package raxcl.math.bigNumberSum.review;

/**
 * 大整数相加复习2
 *
 * @author D30100_chenlong
 * @date 2022/4/20 12:08
 */
public class BigNumberSum2 {
    public static void main(String[] args) {
        System.out.println(bigNumberSum("426709752318", "95481253129"));
    }

    private static String bigNumberSum(String numberA, String numberB) {
        //将两数倒序放入int[]中
        int max = Math.max(numberA.length(),numberB.length());
        int[] arrayA = new int[max];
        int[] arrayB = new int[max];
        for (int i=0; i< numberA.length(); i++){
            arrayA[i] = numberA.charAt(numberA.length()-1-i) - '0';
        }
        for (int i=0; i< numberB.length(); i++){
            arrayB[i] = numberB.charAt(numberB.length()-1-i) - '0';
        }
        //定义个max+1长的int[]，存相加的结果
        int[] resultArr = new int[max+1];
        //遍历相加
        for (int i=0; i< arrayA.length; i++){
            int num = arrayA[i]+arrayB[i];
            if (num>9){
                resultArr[i+1] += 1;
                num %= 10;
            }
            resultArr[i] += num;
        }

        //从右向左遍历，判断有效为，封装为StringBuild
        int index = resultArr.length-1;
        while(resultArr[index] == 0){
            index--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <=index; i++) {
            stringBuilder.append(resultArr[index-i]);
        }
        return stringBuilder.toString();
    }
}
