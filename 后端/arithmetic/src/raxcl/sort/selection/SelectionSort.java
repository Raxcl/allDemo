package raxcl.sort.selection;

import raxcl.swap.Swap;

import java.util.Arrays;

/**
 * 选择排序
 *主要思想就是每次选取一个最值，然后交换
 * @author D30100_chenlong
 * @date 2022/4/20 23:15
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8,30,50,1,33,24,5,-4,7,0};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                //求出最小值
                if (array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            //交换
            if (i != minIndex){
                Swap.swap(array,i,minIndex);
            }
        }
    }
}
