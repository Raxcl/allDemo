package raxcl.sort.selection.review;

import raxcl.swap.Swap;

import java.util.Arrays;

/**
 * 选择排序复习5
 * @author D30100_chenlong
 * @date 2022-05-25 11:15:54
 */
public class SelectionSortReview5 {
    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8,30,50,1,33,24,5,-4,7,0};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j]<array[min]){
                    min=j;
                }
            }
            Swap.swap(array, i, min);
        }
    }
}
