package raxcl.math.getMaxSortedDistance.review;

import java.util.Arrays;

/**
 * 无序数组排序后的最大相邻差复习2
 *
 * @author D30100_chenlong
 * @date 2022/4/19 12:05
 */
public class GetMaxSortedDistance2 {
    public static void main(String[] args) {
        int[] array = new int[]{2,6,3,4,5,10,9};
        System.out.println(getMaxSortedDistance2(array));
    }

    private static int getMaxSortedDistance2(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int d = max-min;
        int bucketNum = array.length;
        Bucket[] bucket = new Bucket[bucketNum];
        //初始化
        for (int i = 0; i < bucketNum; i++) {
            bucket[i] = new Bucket();
        }

        //封装
        for(int a: array){
            int num = (a-min)*(bucketNum-1)/d;
            if (bucket[num].min==null || bucket[num].min>a){
                bucket[num].min=a;
            }
            if (bucket[num].max==null || bucket[num].max<a){
                bucket[num].max=a;
            }
        }

        //求出最大区间
        int maxLength = 0 ;
        int lengthMax = bucket[0].max;
        for (Bucket buck:bucket){
            if (buck.min==null){
                continue;
            }
            int number = buck.min - lengthMax;
            if (number>maxLength){
                maxLength = number;
            }
            lengthMax = buck.max;
        }
        return maxLength;
    }

    private static class Bucket{
        Integer max;
        Integer min;
    }
}
