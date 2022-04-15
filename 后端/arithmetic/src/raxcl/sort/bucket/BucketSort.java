package raxcl.sort.bucket;

import java.util.*;

/**
 * 桶排序
 *
 * @author D30100_chenlong
 * @date 2022/4/14 16:57
 */
public class BucketSort {
    public static void main(String[] args) {
        double[] array = new double[]{4.12,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
        
    }

    private static double[] bucketSort(double[] array) {
        //1. 得到数列的最大值和最小值，并算出差值d
        double max = array[0];
        double min = array[0];
        for (int i=1;i<array.length; i++){
            if (array[i]>max){
                max = array[i];
            }
            if (array[i] < min){
                min = array[i];
            }
        }
        double d =max - min;
        //初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i =0; i<bucketNum; i++){
            bucketList.add(new LinkedList<Double>());
        }
        //3. 遍历原始数组，将每个元素放入桶中
        for (int i = 0; i < array.length; i++) {
            int num = (int)((array[i] - min)* (bucketNum-1)/d);
            bucketList.get(num).add(array[i]);
        }
        
        //4. 对每个桶内部进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            //jdk底层采用了归并排序或归并的优化版本
            Collections.sort(bucketList.get(i));
        }
        //输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list: bucketList){
            for (double element : list){
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }
}
