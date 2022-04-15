package raxcl.sort.bubble;

import java.util.Arrays;

/**
 * 原始冒泡排序 优化3(鸡尾酒排序，避免多数有序的情况）
 *
 * @author D30100_chenlong
 * @date 2022/4/13 13:35
 */
public class BubbleSort3 {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,5,6,7,8,1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        boolean isSorted = true;
        int sortBorder = array.length-1;
        int beginSortBorder = 0;
        int tempIndex = 0;
        for (int i=0; i<array.length/2; i++){

            int temp = 0;
            //左到右
            for (int j=beginSortBorder; j<sortBorder; j++){
                if(array[j]>array[j+1]){
                    isSorted = false;
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    tempIndex = j;
                }
            }
            if (isSorted){
                break;
            }
            sortBorder = tempIndex;

            //右到左
            isSorted = true;
            for (int j=sortBorder; j>beginSortBorder; j--){
                if(array[j]<array[j-1]){
                    isSorted = false;
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
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
