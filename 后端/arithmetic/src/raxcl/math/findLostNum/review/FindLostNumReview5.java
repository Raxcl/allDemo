package raxcl.math.findLostNum.review;

/**
 * 寻找丢失的整数复习5
 *
 * @author D30100_chenlong
 * @date 2022-05-30 15:05:44
 */
public class FindLostNumReview5 {
    public static void main(String[] args) {
        int[] array = {4,1,2,2,5,1,4,3};
        int[] result = findLostNum(array);
        System.out.println(result[0]+","+result[1]);
    }

    private static int[] findLostNum(int[] array) {
        int twoSum = 0;
        for (int num: array){
            twoSum ^= num;
        }

        int index=1;
        while ((twoSum&index)==0){
            index <<= 1;
        }
        int[] nums = new int[2];
        for (int num: array){
            if ((num&index)==0){
                nums[0] ^= num;
            }else{
                nums[1] ^= num;
            }
        }
        return nums;
    }
}
