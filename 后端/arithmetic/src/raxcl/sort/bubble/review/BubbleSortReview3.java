package raxcl.sort.bubble.review;

import raxcl.swap.Swap;

import java.util.Arrays;

/**
 * 冒泡排序复习3
 *
 * @author D30100_chenlong
 * @date 2022/4/17 13:19
 */
public class BubbleSortReview3 {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,4,5,6,7,4,8,1};
        sort3(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort3(int[] array) {
        int beginIndex = 0;
        int endIndex = array.length-1;
        int tempIndex = 0;
        //遍历轮次
        for (int i = 0; i < array.length/2; i++) {
            //左到右
            boolean isSorted = true;
            for (int j = beginIndex; j < endIndex; j++) {
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
            isSorted=true;
            //右到左
            for (int j = endIndex; j>beginIndex; j--) {
                if (array[j]<array[j-1]){
                    Swap.swap(array,j,j-1);
                    isSorted = false;
                    tempIndex = j;
                }
            }
            if (isSorted){
                break;
            }
        }
    }
}
