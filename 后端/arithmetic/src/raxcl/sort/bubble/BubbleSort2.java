package raxcl.sort.bubble;

import java.util.Arrays;

/**
 * 原始冒泡排序 优化2(记录最后一个元素交换的位置）
 *
 * @author D30100_chenlong
 * @date 2022/4/13 13:35
 */
public class BubbleSort2 {
    public static void main(String[] args) {
        int[] array = new int[]{5,8,6,3,9,2,1,7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        boolean isSorted = true;
        int sortBorder = array.length-1;
        int lastIndex = 0;
        for (int i=0; i<array.length-1; i++){

            int temp = 0;
            for (int j=0; j<sortBorder; j++){
                if(array[j]>array[j+1]){
                    isSorted = false;
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    lastIndex = j;
                }
            }
            if (isSorted){
                break;
            }
            sortBorder = lastIndex;
        }
    }
}
