package raxcl.sort.bubble.review;

import java.util.Arrays;

/**
 * 鸡尾酒排序复习2
 *
 * @author D30100_chenlong
 * @date 2022/4/15 9:49
 */
public class BubbleSortReview2 {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,4,5,6,7,4,8,1};
        sort2(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort2(int[] array) {
        int sortedBorder = array.length - 1;
        int beginSortBorder = 0;
        int tempIdex = 0;
        boolean isSorted = true;
        //遍历次数，长度的一半
        for (int i=0; i<(array.length-1)/2; i++){
            //左到右
            for (int j=beginSortBorder; j<sortedBorder; j++){
                if (array[j]> array[j+1]){
                    isSorted = false;
                    swap(array,j,j+1);
                    tempIdex = j;
                }
            }
            if (isSorted){
                break;
            }
            sortedBorder = tempIdex;

            isSorted = true;
            //右到左
            for (int j=sortedBorder; j>beginSortBorder; j--){
                if (array[j]< array[j-1]){
                    isSorted = false;
                    swap(array,j,j-1);
                    tempIdex = j;
                }
            }
            if (isSorted){
                break;
            }
            beginSortBorder = tempIdex;
        }

    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
