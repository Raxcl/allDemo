package raxcl.math.getMaxSortedDistance.review;

import java.util.Arrays;

/**
 * 无序数组排序后的最大相邻差
 *
 * @author D30100_chenlong
 * @date 2022/4/18 11:19
 */
public class GetMaxSortedDistance1 {
    public static void main(String[] args) {
        int[] array = new int[]{2,6,3,4,5,10,9};
        System.out.println(getMaxSortedDistance1(array));
    }

    private static int getMaxSortedDistance1(int[] array) {
        //初始化桶
        int bucketNum = array.length;
        Bucket[] bucket = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            bucket[i]= new Bucket();
        }
        //存入最大值和最小值
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int d = max-min;
        for (int i = 0; i < array.length; i++) {
            int num = (array[i] - min) * (bucketNum - 1) / d;
            if (bucket[num].max== null || bucket[num].max<=array[i]){
                bucket[num].max=array[i];
            }
            if (bucket[num].min== null || bucket[num].min>array[i]){
                bucket[num].min=array[i];
            }
        }

        //得到最大相邻差
        int maxVal=0;
        int leftMax = bucket[0].max;
        for (int i = 1; i < bucket.length-1; i++) {
            if (bucket[i].min==null){
                continue;
            }
            maxVal = bucket[i].min-leftMax;
            leftMax = bucket[i].max;
        }
        return maxVal;
    }

    private static class Bucket{
        Integer min;
        Integer max;
    }
}
