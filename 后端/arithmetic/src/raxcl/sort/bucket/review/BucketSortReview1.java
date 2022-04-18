package raxcl.sort.bucket.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序复习1
 *
 * @author D30100_chenlong
 * @date 2022/4/15 11:21
 */
public class BucketSortReview1 {
    public static void main(String[] args) {
        double[] array = new double[]{4.12,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static double[] bucketSort(double[] array) {
        //得到最大值和最小值
        double max = Arrays.stream(array).max().getAsDouble();
        double min = Arrays.stream(array).min().getAsDouble();
        double d = max-min;
        //初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        //将原始数组放入桶中
        for (int i = 0; i < array.length; i++) {
            int num = (int)((array[i]-min)* (bucketNum-1)/d);
            bucketList.get(num).add(array[i]);
        }

        //对每个桶进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }

        //输出全部元素
        int index=0;
        for(LinkedList<Double> list :bucketList){
            for (Double element : list){
                array[index++] = element;
            }
        }
        return array;

    }
}
