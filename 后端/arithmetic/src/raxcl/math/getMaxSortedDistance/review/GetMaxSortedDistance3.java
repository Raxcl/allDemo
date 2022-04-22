package raxcl.math.getMaxSortedDistance.review;

import java.util.Arrays;

/**
 * 无序数组排序后的最大相邻差复习3
 *
 * @author D30100_chenlong
 * @date 2022/4/21 11:41
 */
public class GetMaxSortedDistance3 {
    public static void main(String[] args) {
        int[] array = new int[]{2,6,3,4,5,10,9};
        System.out.println(getMaxSortedDistance3(array));
    }

    private static int getMaxSortedDistance3(int[] array) {
        //初始化
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int d = max-min;
        //存入大小值
        for (int i = 0; i < bucketNum; i++) {
            int num = (array[i]-min)*(bucketNum-1)/d;
            if (buckets[num].max== null || buckets[num].max<array[i]){
                buckets[num].max=array[i];
            }
            if (buckets[num].min== null || buckets[num].min>array[i]){
                buckets[num].min=array[i];
            }
        }
        int leftIndex = buckets[0].max;
        int maxDis = 0;
        for (Bucket bucket: buckets){
            if (bucket.min!=null){
                int dis = bucket.min - leftIndex;
                if (dis>maxDis){
                    maxDis = dis;
                }
                leftIndex = bucket.max;
            }
        }
        return maxDis;

    }
    private static class Bucket{
        Integer max;
        Integer min;
    }
}
