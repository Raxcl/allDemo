package raxcl.sort.bucket.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序复习4
 *
 * @author D30100_chenlong
 * @date 2022/4/21 10:10
 */
public class BucketSortReview4 {
    public static void main(String[] args) {
        double[] array = new double[]{4.12,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
        bucketSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bucketSort(double[] array) {
        int bucketNum = array.length;
        double max = Arrays.stream(array).max().getAsDouble();
        double min = Arrays.stream(array).min().getAsDouble();
        double d = max-min;
        ArrayList<LinkedList<Double>> buckets = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new LinkedList<>());
        }
        for (int i = 0; i < array.length; i++) {
            int num = (int)((array[i]-min)*(bucketNum-1)/d);
            buckets.get(num).add(array[i]);
        }
        for (LinkedList<Double> list: buckets){
            Collections.sort(list);
        }
        int index=0;
        for (LinkedList<Double> list: buckets){
            for (double number: list){
                array[index++] = number;
            }
        }
    }


}
