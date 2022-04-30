package raxcl.sort.bubble.review;

import raxcl.swap.Swap;

import java.util.Arrays;

/**
 * 冒泡排序复习5
 *
 * @author D30100_chenlong
 * @date 2022-04-28 10:53:17
 */
public class BubbleSortReview5 {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,11,5,6,7,4,8,1};
        sort5(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort5(int[] array) {
       int endIndex = array.length-1;
       int startIndex = 0;
        for (int x = 0; x < array.length/2; x++) {
            boolean isSorted = true;
            int tempIndex =0;
            for (int i = startIndex; i<endIndex; i++){
                if (array[i]>array[i+1]){
                    Swap.swap(array,i,i+1);
                    isSorted=false;
                    tempIndex = i;
                }
            }
            if (isSorted){
                break;
            }
            endIndex = tempIndex;

            isSorted = true;
            for (int i = endIndex; i>startIndex; i--){
                if (array[i]<array[i-1]){
                    Swap.swap(array,i,i-1);
                    isSorted=false;
                    tempIndex = i;
                }
            }
            if (isSorted){
                break;
            }
            startIndex = tempIndex;
        }
    }
}
