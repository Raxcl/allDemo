package raxcl.math.isPowerOfTwo.review;

/**
 * 是否为2的整数次幂复习5
 *
 * @author D30100_chenlong
 * @date 2022-05-19 11:33:03
 */
public class IsPowerOfTwo5 {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(2048));
    }

    private static boolean isPowerOf2(int a) {
        return (a&(a-1))==0;
    }

}
