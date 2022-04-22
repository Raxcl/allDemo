package raxcl.sort.selection.review;

import raxcl.swap.Swap;

import java.util.Arrays;

/**
 * 选择排序复习1
 *
 * @author D30100_chenlong
 * @date 2022/4/22 15:06
 */
public class SelectionSortReview {
    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8,30,50,1,33,24,5,-4,7,0};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[minIndex]>array[j]){
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
