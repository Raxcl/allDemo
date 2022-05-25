package raxcl.sort.insert.review;

import java.util.Arrays;

/**
 * 插入排序复习3
 *
 * @author D30100_chenlong
 * @date 2022-05-09 14:36:21
 */
public class insertSortReview3 {
    public static void main(String[] args) {
        int[] array = { 12,1,3,46,5,0,-3,12,35,16};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i-1;
            for (; j >=0 && array[j]>temp; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = temp;
        }
    }
}
