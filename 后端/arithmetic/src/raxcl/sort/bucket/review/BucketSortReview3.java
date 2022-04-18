package raxcl.sort.bucket.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序复习3
 *
 * @author D30100_chenlong
 * @date 2022/4/18 10:02
 */
public class BucketSortReview3 {
    public static void main(String[] args) {
        double[] array = new double[]{4.12,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
        bucketSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bucketSort(double[] array) {
        double max = Arrays.stream(array).max().getAsDouble();
        double min = Arrays.stream(array).min().getAsDouble();
        double d = max-min;
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }
        for (double a:array){
            int num = (int)((a-min)*(bucketNum-1)/d);
            bucketList.get(num).add(a);
        }

        //桶内排序
        for(LinkedList<Double> list:bucketList){
            Collections.sort(list);
        }
        //对原数组排序
        int index = 0;
        for(LinkedList<Double> list:bucketList){
            for(double a:list){
                array[index++] = a;
            }
        }
    }
}
