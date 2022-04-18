package raxcl.math.greatestCommonDivisor;

/**
 * 最大公约数
 *
 * @author D30100_chenlong
 * @date 2022/4/16 14:41
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(greatestCommonDivisor3(49,56));
        System.out.println(greatestCommonDivisor3(100,80));
        System.out.println(greatestCommonDivisor3(1000000,2000000));
    }

    //暴力破解
    private static int greatestCommonDivisor(int a, int b) {
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        if(max%min==0){
            return min;
        }
        for (int i = min/2; i >1; i--) {
            if (min%i==0 && max%i==0){
                return i;
            }
        }
        return 1;
    }
    //辗转相除法
    private static int greatestCommonDivisor1(int a, int b) {
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        if (max%min==0){
            return min;
        }
        return greatestCommonDivisor1(max%min,min);
    }
    //更相减损术
    private static int greatestCommonDivisor2(int a, int b) {
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        if (max==min){
            return min;
        }
        return greatestCommonDivisor2(max-min,min);
    }
    //最优解 更相减损术和辗转相除法结合
    //如果都是偶数，就是2（a>>1,b>>1）,
    //如果a是偶数,(a>>2,b),如果b是偶数，（a,b>>2）
    //如果都是奇数，(max-min,min)
    private static int greatestCommonDivisor3(int a, int b) {

        if (a==b){
            return a;
        }
        if ((a&1)==0 && (b&1)==0){
            return greatestCommonDivisor3(a>>1,b>>1)<<1;
        }else if((a&1)==0 && (b&1)!=0){
            return greatestCommonDivisor3(a>>1,b);
        }else if((a&1)!=0 && (b&1)==0){
            return greatestCommonDivisor3(a,b>>1);
        }else {
            int max = Math.max(a,b);
            int min = Math.min(a,b);
            return greatestCommonDivisor3(max-min,min);
        }
    }
}
