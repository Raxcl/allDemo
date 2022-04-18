package raxcl.math.isPowerOfTwo;

/**
 * 判断一个数是否是2的整数次幂方
 *
 * @author D30100_chenlong
 * @date 2022/4/16 15:49
 */
public class IsPowerOf2 {
    public static void main(String[] args) {
        System.out.println(isPowerOf21(2048));
    }

    //暴力破解
    private static boolean isPowerOf2(int a) {
        if ((a&1)!=0){
            return false;
        }
        if (a/2==1){
            return true;
        }
        return isPowerOf2(a/2);
    }

    //高级版---n&n-1
    private static boolean isPowerOf21(int a) {
        return (a&(a-1))==0;
    }

}
