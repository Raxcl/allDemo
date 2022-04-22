package raxcl.sort.bubble.review;

import raxcl.swap.Swap;

import java.util.Arrays;

/**
 * 冒泡排序复习4
 *
 * @author D30100_chenlong
 * @date 2022/4/20 11:03
 */
public class BubbleSortReview4 {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,4,5,6,7,4,8,1};
        sort4(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort4(int[] array) {
        int endIndex = array.length-1;
        int startIndex = 0;
        boolean isSorted = true;
        int tempIndex = 0;
        for (int i = 0; i < (array.length-1)/2; i++) {
            //左到右
            for (int j = startIndex; j < endIndex; j++) {
                if (array[j]>array[j+1]){
                    Swap.swap(array,j,j+1);
                    isSorted = false;
                    tempIndex = j;
                }
            }
            if (isSorted){
                break;
            }
            endIndex = tempIndex;

            //右到左
            isSorted = true;
            for (int j = endIndex; j >startIndex ; j--) {
                if (array[j]<array[j-1]){
                    Swap.swap(array,j,j-1);
                    isSorted = false;
                    tempIndex = j;
                }
            }
            if (isSorted){
                break;
            }
            startIndex = tempIndex;
        }
    }
}
