package raxcl.sort.shell.review;

import java.util.Arrays;

/**
 * 希尔排序复习4
 *
 * @author D30100_chenlong
 * @date 2022-05-09 10:26:16
 */
public class ShellSortReview4 {
    public static void main(String[] args) {
        int[] array = {5,3,9,12,6,1,7,2,4,11,8,10};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void shellSort(int[] array) {
       int d = array.length;
       while(d>0){
           d >>= 1;
           //每轮d,尽量构建有序环境，减轻插入排序压力
           for (int x = 0; x < d; x++) {
               //插入排序
               for (int i = x+d; i < array.length; i += d) {
                   int temp = array[i];
                   int j = i-d;
                   for (; j >= x && temp<array[j]; j-=d) {
                       array[j+d] = array[j];
                   }
                   array[j+d] = temp;
               }
           }
       }
    }


}
