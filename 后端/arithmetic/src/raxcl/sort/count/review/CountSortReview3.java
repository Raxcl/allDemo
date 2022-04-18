package raxcl.sort.count.review;

import java.util.Arrays;

/**
 * 技术排序复习3
 *
 * @author D30100_chenlong
 * @date 2022/4/18 9:55
 */
public class CountSortReview3 {
    public static void main(String[] args) {
        int[] array = new int[] {4,4,6,5,3,2,8,1,7,5,6,0,10};
        countSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void countSort(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int d = max-min;
        int[] countArray = new int[d+1];
        for (int a:array){
            countArray[a-min]++;
        }
        //排序
        int index=0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j=0;j<countArray[i];j++){
                array[index++] = i+min;
            }
        }
    }

}
