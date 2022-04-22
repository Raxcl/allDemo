package raxcl.math.bigNumberSum.review;

/**
 * 大整数相加复习3
 *
 * @author D30100_chenlong
 * @date 2022/4/22 14:02
 */
public class BigNumberSum3 {
    public static void main(String[] args) {
        System.out.println(bigNumberSum("426709752318", "95481253129"));
    }

    private static String bigNumberSum(String a, String b) {
        int[] results = new int[Math.max(a.length(),b.length())+1];
        for (int i = 0; i < results.length-1; i++) {
            int sum =0;
            if (a.length()-1-i<0){
                sum = (b.charAt(b.length()-1-i)-'0');
            }else if(b.length()-1-i<0){
                sum = (a.charAt(a.length()-1-i)-'0');
            }else{
                sum = (a.charAt(a.length()-1-i)-'0') + (b.charAt(b.length()-1-i)-'0');
            }
            if (sum>9){
                results[i+1]++;
            }
            results[i] += sum%10;
        }
        //确定有效位并翻转
        int index = 0;
        for (int i = results.length-1; i >=0 ; i--) {
            if (results[i]!=0){
                index = i;
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index; i >=0 ; i--) {
            stringBuilder.append(results[i]);
        }


        return stringBuilder.toString();
    }
}
