package raxcl.math.bigNumberSum.review;

public class BigNumberSumAllReview {
    public static void main(String[] args) {
        System.out.println(bigNumberSum("426709752318", "95481253129"));
    }

    private static String bigNumberSum(String a, String b) {
        int length = Math.max(a.length(), b.length());
        int[] arrayA = new int[length];
        int[] arrayB = new int[length];
        for (int i = 0; i < a.length(); i++) {
            arrayA[i] = a.charAt(a.length() - 1 - i) - '0';
        }
        for (int i = 0; i < b.length(); i++) {
            arrayB[i] = b.charAt(b.length() - 1 - i) - '0';
        }
        int[] result = new int[length+1];
        for (int i = 0; i < result.length - 1; i++) {
            int sum = arrayA[i] + arrayB[i];
            if(sum > 9) {
                result[i+1]++;
            }
            result[i] += sum%10;
        }
        int newLength = result.length;
        // 消除0
        if (result[result.length-1] == 0) {
            newLength--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < newLength; i++) {
            stringBuilder.append(result[newLength-1-i]);
        }
        return stringBuilder.toString();
    }

}
