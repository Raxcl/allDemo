package raxcl.sort.count.review;

import java.util.Arrays;

/**
 * 计数排序复习2
 *
 * @author D30100_chenlong
 * @date 2022/4/16 10:51
 */
public class CountSortReview2 {
    public static void main(String[] args) {
        int[] array = new int[] {4,4,6,5,3,2,8,1,7,5,6,0,10};
        countSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void countSort(int[] array) {
        //求出最大最小和区间
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int d = max-min;
        //开始计数
        int[] countArray = new int[d+1];
        for (int a : array){
            countArray[a-min]++;
        }
        //排序
        int index = 0;
        for (int i=0;i<countArray.length;i++){
            for (int j=0;j<countArray[i];j++){
                array[index++]= i+min;
            }
        }
    }


}
