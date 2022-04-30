package raxcl.math.greatestCommonDivisor.review;

/**
 * 得到最大公约数复习4
 *
 * @author D30100_chenlong
 * @date 2022-04-26 12:07:55
 */
public class GreatestCommonDivisorReview4 {
    public static void main(String[] args) {
        System.out.println(greatestCommonDivisor(49,56));
        System.out.println(greatestCommonDivisor(100,80));
        System.out.println(greatestCommonDivisor(1000000,2000000));
    }

    private static int greatestCommonDivisor(int a, int b) {
        if (a==b){
            return a;
        }
        if ((a&1)==0 && (b&1)==0){
            return greatestCommonDivisor(a>>1,b>>1)<<1;
        }else if((a&1)!=0 && (b&1)==0){
            return greatestCommonDivisor(a,b>>1);
        }else if((a&1)==0 && (b&1)!=0){
            return greatestCommonDivisor(a>>1,b);
        }else{
            int max=Math.max(a,b);
            int min=Math.min(a,b);
            return greatestCommonDivisor(max-min,min);
        }

    }


}
