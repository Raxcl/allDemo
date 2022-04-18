package raxcl.sort.count.review;

import java.util.Arrays;

/**
 * 计数排序第一轮复习
 *
 * @author D30100_chenlong
 * @date 2022/4/15 10:59
 */
public class CountSortReview1 {
    public static void main(String[] args) {
        int[] array = new int[] {4,4,6,5,3,2,8,1,7,5,6,0,10};
        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] countSort(int[] array) {
        //求出最大值和最小值
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int d = max-min;
        int[] countArray = new int[d+1];
        for (int i=0; i<array.length; i++){
            countArray[array[i]-min]++;
        }
        //输出
        int index =0;
        for(int i=0; i<countArray.length; i++){
            for (int j=0; j<countArray[i]; j++){
                array[index++] = i+min;
            }
        }
        return array;
    }
}
