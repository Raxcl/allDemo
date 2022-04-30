package raxcl.sort.shell.review;

import java.util.Arrays;

/**
 * 希尔排序复习1
 *
 * @author D30100_chenlong
 * @date 2022/4/22 15:47
 */
public class ShellSortReview1 {
    public static void main(String[] args) {
        int[] array = {5,3,9,12,6,1,7,2,4,11,8,10};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void shellSort(int[] array) {
        //希尔增量
        int d = array.length;
        //间隔减少
        while(d>0){
            d >>= 1;
            //所有间隔
            for (int x=0; x<d; x++){
                //单轮间隔
                for (int i = x+d; i < array.length; i +=d) {
                    int temp = array[i];
                    int j = i -d;
                    for (; j >=0 && temp<array[j]; j = j-d) {
                        array[j+d] = array[j];
                    }
                    array[j+d] = temp;
                }
            }

        }
    }


}
