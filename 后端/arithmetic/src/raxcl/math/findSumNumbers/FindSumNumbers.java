package raxcl.math.findSumNumbers;

import java.util.*;

/**
 * 两数之和
 *
 * @author D30100_chenlong
 * @date 2022/5/19 18:33
 */
public class FindSumNumbers {
    public static void main(String[] args) {
        int[] nums = {5,12,6,3,9,2,1,7};
        List<int[]> resultList = threeSum(nums, 13);
        for (int[] array: resultList){
            System.out.print(array[0]+":"+array[1]+":"+array[2]+" ");
        }
    }
    //两数之和，返回下标，采用hash表的方式
    public static List<int[]> twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        for(int i=0; i< nums.length; i++){
            int other = target - nums[i];
            if (map.containsKey(other)){
                list.add(new int[]{i,map.get(other)});
            }
            map.put(nums[i],i);
        }
        return list;
    }

    //三数之和，返回值，采用双指针法
    public static List<int[]> threeSum(int[] nums, int target){
        Arrays.sort(nums);
        List<int[]> list = new ArrayList<>();
        //大循环
        for (int i=0; i<nums.length; i++){
            int twoSum = target - nums[i];

            int left = i;
            int right = nums.length-1;
            while(left!=right){
                int num = nums[left]+nums[right];
                if (num==twoSum){
                    list.add(new int[]{nums[i],nums[left],nums[right]});
                    left++;
                }else if(num<twoSum){
                    left++;
                }else {
                    right--;
                }
            }
        }

        return list;
    }
}