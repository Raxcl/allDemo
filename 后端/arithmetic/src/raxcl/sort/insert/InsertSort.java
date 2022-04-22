package raxcl.sort.insert;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author D30100_chenlong
 * @date 2022/4/20 23:25
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = { 12,1,3,46,5,0,-3,12,35,16};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertValue = array[i];
            int j = i-1;
            //从右到左比较元素的同时，进行元素复制
            for (; j >=0 && insertValue<array[j]; j--) {
                 array[j+1] = array[j];
            }
            //insertValue 的值插入适当位置
            //这里的j+1其实是因为当面for循环跳出时候多减了
            array[j+1] = insertValue;

        }
    }
}
