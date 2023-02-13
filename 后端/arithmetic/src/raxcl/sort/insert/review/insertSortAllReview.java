package raxcl.sort.insert.review;

import java.util.Arrays;

/**
 * @author Raxcl
 * @date 2023/2/12 19:25
 */
public class insertSortAllReview {
    public static void main(String[] args) {
        int[] array = { 12,1,3,46,5,0,-3,12,35,16};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertValue = array[i];
            int j = i-1;
            for (;  j>=0 && insertValue < array[j]; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = insertValue;
        }
    }


}
