package raxcl.sort.shell.review;

import java.util.Arrays;

/**
 * 希尔排序复习5
 *
 * @author D30100_chenlong
 * @date 2022-05-30 14:47:32
 */
public class ShellSortReview5 {
    public static void main(String[] args) {
        int[] array = {5,3,9,12,6,1,7,2,4,11,8,10};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void shellSort(int[] array) {
        int d = array.length;
        while(d>0){
            d >>= 1;
            for (int x = 0; x < d; x++) {
                for (int i = x+d; i < array.length; i +=d) {
                    int temp = array[i];
                    int j = i-d;
                    for (; j >=x && array[j]>temp; j-=d) {
                        array[j+d] = array[j];
                    }
                    array[j+d] = temp;
                }
            }
        }

    }


}
