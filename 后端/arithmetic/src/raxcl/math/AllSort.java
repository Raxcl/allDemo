package raxcl.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * @author D30100_chenlong
 * @date 2022/6/23 10:36
 */
public class AllSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        for (int i = 0; i < nums.length; i++) {
            int[] num = new int[]{nums[i]};
            generate(nums,1,num);
        }
    }

    private static void generate(int[] nums, int i, int[] num) {
        if (i==nums.length){
            for (int j = 0; j < num.length; j++) {
                System.out.print(num[j]);
            }
            System.out.print(",");
        }
        if (i<nums.length){
            List<Integer> list = new ArrayList<>();
            int[] num2 = new int[num.length+1];
            for (int j = 0; j < num.length; j++) {
                num2[j] = num[j];
            }
            for (int j = 0; j < nums.length; j++) {
                int flag = 0;
                for (int k = 0; k < num.length; k++) {
                    if (nums[j]!=num[k]){
                        flag++;
                    }
                }
                if (flag==num.length){
                    list.add(nums[j]);continue;
                }else {
                    flag = 0;
                }
            }
            for (int j = 0; j < list.size(); j++) {
                num2[num2.length-1] = list.get(j);
                generate(nums,i+1,num2);
            }
        }
    }
}
