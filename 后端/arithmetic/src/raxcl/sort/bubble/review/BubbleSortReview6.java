package raxcl.sort.bubble.review;

import raxcl.swap.Swap;

import java.util.Arrays;

/**
 * 冒泡排序复习6
 *
 * @author D30100_chenlong
 * @date 2022-06-06 13:42:35
 */
public class BubbleSortReview6 {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,11,5,6,7,4,8,1};
        sort6(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort6(int[] array) {
       int startIndex = 0;
       int endIndex = array.length-1;
       int temp = 0;
       boolean isSorted = true;
        for (int i = 0; i < array.length/2; i++) {
            for (int j = startIndex; j < endIndex ; j++) {
                if (array[j]>array[j+1]){
                    Swap.swap(array,j,j+1);
                    temp = j+1;
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
            endIndex = temp;

            isSorted = true;
            for (int j = endIndex; j > startIndex ; j--) {
                if (array[j]<array[j-1]){
                    Swap.swap(array,j,j-1);
                    temp = j-1;
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
            startIndex = temp;
        }
    }
}
