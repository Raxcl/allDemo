package raxcl.math.isPowerOfTwo.review;

/**
 * 是否为2的整数次幂复习1
 *
 * @author D30100_chenlong
 * @date 2022/4/18 11:12
 */
public class IsPowerOfTwo1 {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(2048));
    }

    private static boolean isPowerOf2(int number) {
        return (number&(number-1))==0;
    }

    //1000
    //0111
    //&==0

}
