package raxcl.sort.bubble.review;

import java.util.Arrays;

/**
 * 冒泡排序（鸡尾酒排序复习1）
 *
 * @author D30100_chenlong
 * @date 2022/4/14 11:05
 */
public class BubbleSortReview1 {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,4,5,6,7,4,8,1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        boolean isSorted = true;
        int sortBorder = array.length-1;
        int beginSortBorder = 0;
        int tempIndex = 0;
        //左到右
        for (int i=0; i<array.length/2; i++){
            for (int j=beginSortBorder; j<sortBorder; j++) {
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                    tempIndex = j;
                }
            }
            if (isSorted){
                break;
            }
            sortBorder = tempIndex;
            //右到左
            isSorted =true;
            for (int j=sortBorder; j>beginSortBorder; j--) {
                if(array[j]<array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    isSorted = false;
                    tempIndex = j;
                }
            }
            if (isSorted){
                break;
            }
            beginSortBorder = tempIndex;
        }

    }

}
