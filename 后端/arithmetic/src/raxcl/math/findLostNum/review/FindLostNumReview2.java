package raxcl.math.findLostNum.review;

/**
 * 寻找丢失的整数复习2
 *
 * @author D30100_chenlong
 * @date 2022-04-26 11:14:53
 */
public class FindLostNumReview2 {
    public static void main(String[] args) {
        int[] array = {4,1,2,2,5,1,4,3};
        int[] result = findLostNum(array);
        System.out.println(result[0]+","+result[1]);
    }

    private static int[] findLostNum(int[] array) {
        int sum = 0;
        for (int a: array){
            sum ^= a;
        }
        int x=1;
        while((sum&x)==0){
            x <<=1;
        }
        int[] result = new int[2];
        for (int a:array){
            if ((a&x)==0){
                result[0] ^=a;
            }else {
                result[1] ^=a;
            }
        }
        return result;
    }
}
