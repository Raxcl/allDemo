package raxcl.sort.count;

import java.util.Arrays;

/**
 * 计数排序优化1
 *
 * @author D30100_chenlong
 * @date 2022/4/14 14:26
 */
public class CountSort1 {
    public static void main(String[] args) {
        int[] array = new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] countSort(int[] array) {
        //1. 得到数列的最大值和最小值，并算出差值d
        int max = array[0];
        int min = array[0];
        for(int i=1; i<array.length; i++){
            if (array[i]>max){
                max = array[i];
            }
            if (array[i]<min){
                min = array[i];
            }
        }
        int d = max - min;
        //创建统计数组并统计对应元素的个数
        int[] countArray = new int[d+1];
        for (int a : array) {
            countArray[a - min]++;
        }
        //统计数组做变形，后面的元素等于前面的元素之和
        for (int i=1; i<countArray.length; i++){
            countArray[i] += countArray[i-1];
        }
        //4. 倒序遍历原始数列，从统计数组找到正确位置，输出到结果数列
        int[] sortedArray = new int[array.length];
        for (int i=array.length-1; i>=0; i--){
            sortedArray[countArray[array[i]-min]-1] = array[i];
            countArray[array[i]-min]--;
        }
        return sortedArray;
    }
}
