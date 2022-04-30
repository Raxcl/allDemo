package raxcl.sort.count.review;

import java.util.Arrays;

/**
 * 计数排序第一轮复习
 *
 * @author D30100_chenlong
 * @date 2022-04-26 14:51:04
 */
public class CountSortReview1 {
    public static void main(String[] args) {
        int[] array = new int[] {4,4,6,5,3,2,8,1,7,5,6,0,10};
        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] countSort(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int d = max-min;
        int[] countArray = new int[d+1];
        for (int a : array) {
            countArray[a - min]++;
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i-1];
        }

        //倒叙遍历原始数列，从统计数组找到正确位置，输出到结果数列
        int[] sortedArray = new int[array.length];
        for (int i = array.length-1; i >=0 ; i--) {
            sortedArray[countArray[array[i]-min]-1] = array[i];
            countArray[array[i]-min]--;
        }
        return sortedArray;
    }
}
