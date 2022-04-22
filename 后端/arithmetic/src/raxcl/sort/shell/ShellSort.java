package raxcl.sort.shell;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author D30100_chenlong
 * @date 2022/4/21 12:10
 */
public class ShellSort {
    //希尔排序的增量
    public static void shellSort(int[] array){
        int d = array.length;
        //间隔减少
        while(d>1){
            //使用希尔增量的方式，即每次折半
            d = d/2;
            //所有间隔
            for (int x=0; x<d; x++){
                //1 4 7 9 插入排序
                for (int i=x+d; i< array.length; i=i+d){
                    int temp = array[i];
                    int j;
                    for (j=i-d;j>=0 && array[j] >temp; j=j-d ){
                        array[j+d] = array[j];
                    }
                    array[j+d] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5,3,9,12,6,1,7,2,4,11,8,10};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

}
