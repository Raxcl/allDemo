package raxcl.math;


import java.util.*;


/**
 * @author D30100_chenlong
 * @date 2022/4/11 10:52
 */
public class test {
    public static void main(String[] args) {
        int[] arr = {2,4,3,1};
        System.arraycopy(arr,0,arr,1,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public int toGoatLatin(int[] nums) {
        //状态转移方程
//        f(0):               a0*0 + a1*1 + a2*2 +a3*3
//        f(1):        a3*0 + a0*1 + a1*2 + a2*3
//        f(2): a2*0 + a3*1 + a0*2 + a1*3
//        f(n): f(n-1) + sum(nums) - n* nums[n-i] ;
        int f=0, n=nums.length, numSum = Arrays.stream(nums).sum();
        //求出第一轮的和f(0)
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int res = f;
        for(int i=n-1; i>0; i--){
            //求出f(1)的值，一直到f(n)
            f += numSum - n*nums[i];
            res = Math.max(res, f);
        }
        return res;
    }
}

