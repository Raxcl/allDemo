package raxcl.math.bigNumberSum.review;

/**
 * 大整数相加复习4
 *
 * @author D30100_chenlong
 * @date 2022-04-25 13:05:11
 */
public class BigNumberSum4 {
    public static void main(String[] args) {
        System.out.println(bigNumberSum("426709752318", "95481253129"));
    }

    private static String bigNumberSum(String a, String b) {
        int max = Math.max(a.length(),b.length());
        int[] numberA = new int[max];
        int[] numberB = new int[max];
        int[] result = new int[max+1];
        for (int i=0; i<a.length(); i++){
            numberA[i] = a.charAt(a.length()-1-i)-'0';
        }
        for (int i=0; i<b.length(); i++){
            numberB[i] = b.charAt(b.length()-1-i)-'0';
        }
        for (int i=0; i<max; i++){
            int num = numberA[i] + numberB[i];
            if (num>9){
                result[i+1] += 1;
                num %=10;
            }
            result[i] += num ;
        }

        int endIndex = 0;
        for (int i = result.length-1; i >=0 ; i--) {
            if (result[i]!=0){
                endIndex = i;
                break;
            }
        }
        int index=0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = endIndex; i >=0 ; i--) {
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();
    }
}
