package raxcl.math.isPowerOfTwo.review;

/**
 * 是否为2的整数次幂复习2
 *
 * @author D30100_chenlong
 * @date 2022/4/19 11:59
 */
public class IsPowerOfTwo2 {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(2048));
    }

    private static boolean isPowerOf2(int num) {
        return (num&(num-1))==0;
    }

}
