package raxcl.sort.shell.review;

import java.util.Arrays;

/**
 * 希尔排序复习3
 *
 * @author D30100_chenlong
 * @date 2022-04-28 10:00:27
 */
public class ShellSortReview3 {
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
                   int j = i-d;
                   int temp = array[i];
                   for (; j >=x && temp<array[j]; j -=d) {
                        array[j+d] = array[j];
                   }
                   array[j+d] = temp;
               }
           }
       }
    }


}
