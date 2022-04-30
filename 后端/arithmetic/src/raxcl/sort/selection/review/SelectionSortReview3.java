package raxcl.sort.selection.review;

import raxcl.swap.Swap;

import java.util.Arrays;

/**
 * 选择排序复习3
 *
 * @author D30100_chenlong
 * @date 2022-04-27 09:44:06
 */
public class SelectionSortReview3 {
    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8,30,50,1,33,24,5,-4,7,0};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int tempIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[tempIndex]>array[j]){
                    tempIndex = j;
                }
            }
            Swap.swap(array,i,tempIndex);
        }
    }
}
