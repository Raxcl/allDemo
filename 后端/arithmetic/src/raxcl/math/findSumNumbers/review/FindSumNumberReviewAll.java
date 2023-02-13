package raxcl.math.findSumNumbers.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author Raxcl
 * @date 2023/2/13 10:13
 */
public class FindSumNumberReviewAll {
    public static void main(String[] args) {
        int[] nums = {5,12,6,3,9,2,1,7};
        List<int[]> resultList = threeSum(nums, 13);
        for (int[] array: resultList){
            System.out.print(array[0]+":"+array[1]+":"+array[2]+" ");
        }
    }

    private static List<int[]> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int twoSum = target - nums[i];
            int left = i;
            int right = nums.length -1;
            while (left!=right) {
                int num = nums[left] + nums[right];
                if (num == twoSum) {
                    list.add(new int[]{nums[i], nums[left], nums[right]});
                    left++;
                } else if (num < twoSum) {
                    left++;
                }else right--;
            }
        }
        return list;
    }

    private static List<int[]> twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                list.add(new int[]{i, map.get(other)});
            }
            map.put(nums[i], i);
        }
        return list;
    }
}
