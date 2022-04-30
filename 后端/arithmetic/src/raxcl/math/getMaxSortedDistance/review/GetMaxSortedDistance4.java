package raxcl.math.getMaxSortedDistance.review;

import java.util.Arrays;

/**
 * 无序数组排序后的最大相邻差复习4
 *
 * @author D30100_chenlong
 * @date 2022-04-26 13:35:46
 */
public class GetMaxSortedDistance4 {
    public static void main(String[] args) {
        int[] array = new int[]{2,6,3,4,5,10,9};
        System.out.println(getMaxSortedDistance3(array));
    }

    private static int getMaxSortedDistance3(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int d = max-min;
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }
        for (int a:array){
            int num = (a-min)*(bucketNum-1)/d;
            if (buckets[num].min==null || buckets[num].min<a){
                buckets[num].min=a;
            }
            if (buckets[num].max==null || buckets[num].max<a){
                buckets[num].max=a;
            }
        }
        int leftIndex = buckets[0].max;
        int maxIndex =0 ;
        for (Bucket bucket:buckets){
            if (bucket.min==null){
                continue;
            }
            maxIndex = Math.max(maxIndex, bucket.min-leftIndex);
            leftIndex = bucket.max;
        }
        return maxIndex;

    }
    private static class Bucket{
        Integer max;
        Integer min;
    }
}
