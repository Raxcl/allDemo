package raxcl.math.getMaxSortedDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 得到排序后相邻两个数值的最大差值
 *
 * @author D30100_chenlong
 * @date 2022/4/16 17:09
 */
public class GetMaxSortedDistance {
    //桶
    private static class Bucket{
        Integer min;
        Integer max;
    }


    public static void main(String[] args) {
        int[] array = new int[]{2,6,3,4,5,10,9};
        System.out.println(getMaxSortedDistance(array));
    }

    private static int getMaxSortedDistance(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int d = max-min;
        //如果最大值和最小值相等，说明元素都相等，返回0
        if (d==0){
            return 0;
        }
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        //初始化桶
        for (int i = 0; i < array.length; i++) {
            buckets[i] = new Bucket();
        }
        //将数值存入桶中
        for (int i = 0; i < array.length; i++) {
            int index = (array[i]-min)*(bucketNum-1)/d;
            if (buckets[index].min==null || buckets[index].min>array[i]){
                buckets[index].min=array[i];
            }
            if (buckets[index].max==null || buckets[index].max<array[i]){
                buckets[index].max=array[i];
            }
        }
        //遍历桶，找到最大差值
        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null){
                continue;
            }
            if (buckets[i].min-leftMax>maxDistance){
                maxDistance = buckets[i].min-leftMax;
            }
            leftMax = buckets[i].max;
        }
        return maxDistance;
    }
}
