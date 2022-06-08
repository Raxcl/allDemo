package raxcl.math.findSumNumbers.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和复习3
 * 一次遍历+双指针
 *
 * @author D30100_chenlong
 * @date 2022-05-30 13:59:31
 */
public class FindSumNumberReview3 {
    public static void main(String[] args) {
        int[] nums = {5,12,6,3,9,2,1,7};
        List<int[]> resultList = threeSum(nums, 13);
        for (int[] array: resultList){
            System.out.print(array[0]+":"+array[1]+":"+array[2]+" ");
        }
    }

    private static List<int[]> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            int twoSum = target- nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int temp = nums[left]+nums[right];
                if(temp==twoSum){
                    list.add(new int[]{nums[i],nums[left], nums[right]});
                    left++;
                }else if(temp<twoSum){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return list;
    }
}
