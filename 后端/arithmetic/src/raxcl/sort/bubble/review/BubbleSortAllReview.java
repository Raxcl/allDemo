package raxcl.sort.bubble.review;

import java.util.Arrays;

import static raxcl.swap.Swap.swap;

public class BubbleSortAllReview {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,5,6,7,8,1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 鸡尾酒排序
     * @param array
     */
    private static void sort(int[] array) {
        boolean isSorted = true;
        int beginSortBorder = 0;
        int sortBorder = array.length -1;
        int tempIndex = 0;
        for (int i = 0; i < array.length/2; i++) {
            for(int j=beginSortBorder; j<sortBorder;j++) {
                if (array[j]>array[j+1]) {
                    isSorted = false;
                    swap(array,j,j+1);
                    tempIndex = j;
                }
            }
            if (isSorted) {
                break;
            }
            sortBorder = tempIndex;
            isSorted = true;
            for (int j = sortBorder; j>beginSortBorder;j--) {
                if (array[j] < array[j-1]) {
                    isSorted = false;
                    swap(array,j,j-1);
                    tempIndex = j;
                }
            }
            if (isSorted) {
                break;
            }
            beginSortBorder = tempIndex;
        }
    }
}
