package raxcl.math.greatestCommonDivisor.review;

public class GreatestCommonDivisorAllReview {
    public static void main(String[] args) {
        System.out.println(greatestCommonDivisor3(49,56));
        System.out.println(greatestCommonDivisor3(100,80));
        System.out.println(greatestCommonDivisor3(1000000,2000000));
    }

    private static int greatestCommonDivisor3(int a, int b) {
        if(a == b) return a;
        if ((a&1)==0 && (b&1) == 0) {
            return greatestCommonDivisor3(a>>1, b>>1)<<1;
        } else if ((a&1)!=0 && (b&1) == 0) {
            return greatestCommonDivisor3(a, b>>1);
        } else if((a&1)==0 && (b&1) != 0) {
            return greatestCommonDivisor3(a>>1, b);
        } else {
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            return greatestCommonDivisor3(max-min, min);
        }
    }

    private static int greatestCommonDivisor2(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (max%min == 0) return min;
        return greatestCommonDivisor2(max%min, min);
    }

    private static int greatestCommonDivisor(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (max%min == 0) return min;
        for (int i = min/2; i > 1; i--) {
            if (min%i == 0 && max%i == 0) {
                return i;
            }
        }
        return 1;
    }
}
