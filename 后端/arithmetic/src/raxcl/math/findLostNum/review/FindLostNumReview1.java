package raxcl.math.findLostNum.review;

/**
 * 寻找丢失的整数复习1
 *
 * @author D30100_chenlong
 * @date 2022/4/22 16:11
 */
public class FindLostNumReview1 {
    public static void main(String[] args) {
        int[] array = {4,1,2,2,5,1,4,3};
        int[] result = findLostNum(array);
        System.out.println(result[0]+","+result[1]);
    }

    private static int[] findLostNum(int[] array) {
        int sum =0;
        for (int a: array){
            sum ^= a;
        }
        int index=1;
        while((sum&index)==0){
            index <<= 1;
        }
        int[] result = new int[2];
        for(int a: array){
            if ((a&index)==0){
                result[0] ^= a;
            }else{
                result[1] ^= a;
            }
        }
        return result;
    }
}
