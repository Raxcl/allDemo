package raxcl.math.isPowerOfTwo.review;

/**
 * 复习3
 *
 * @author D30100_chenlong
 * @date 2022/4/21 10:52
 */
public class IsPowerOfTwo3 {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(2048));
    }

    private static boolean isPowerOf2(int a) {
        return (a&(a-1))==0;
    }

}
