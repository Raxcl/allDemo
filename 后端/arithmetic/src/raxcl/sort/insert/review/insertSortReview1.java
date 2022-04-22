package raxcl.sort.insert.review;

import java.util.Arrays;

/**
 * 插入排序复习1
 *
 * @author D30100_chenlong
 * @date 2022/4/22 15:26
 */
public class insertSortReview1 {
    public static void main(String[] args) {
        int[] array = { 12,1,3,46,5,0,-3,12,35,16};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertSort(int[] array) {
        //确认一个有序区，插入
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i-1;
            for (; j >=0 && temp < array[j]; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = temp;
        }
    }
}
