package raxcl.sort.bucket.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序复习2
 *
 * @author D30100_chenlong
 * @date 2022/4/16 11:03
 */
public class BucketSortReview2 {
    public static void main(String[] args) {
        double[] array = new double[]{4.12,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
        bucketSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bucketSort(double[] array) {
        //求最大值和最小值
        double max = Arrays.stream(array).max().getAsDouble();
        double min = Arrays.stream(array).min().getAsDouble();
        double d = max-min;
        //初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i <bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }
        //存进不同桶
        for (double value : array) {
            int num = (int) ((value - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(value);
        }
        //桶内排序
        for (LinkedList<Double> list : bucketList) {
            Collections.sort(list);
        }

        //将排序后的数据赋值给排序后
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (int i = 0; i < list.size(); i++) {
                array[index++] = list.get(i);
            }
        }

    }


}
