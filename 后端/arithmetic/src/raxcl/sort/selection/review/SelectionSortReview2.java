package raxcl.sort.selection.review;

import raxcl.swap.Swap;

import java.util.Arrays;

/**
 * 选择排序复习2
 *
 * @author D30100_chenlong
 * @date 2022-04-25 13:24:25
 */
public class SelectionSortReview2 {
    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8,30,50,1,33,24,5,-4,7,0};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex= i;
            for (int j = i+1; j < array.length; j++) {
                if (array[minIndex]>array[j]){
                    minIndex = j;
                }
            }
            Swap.swap(array,minIndex,i);
        }
    }
}
