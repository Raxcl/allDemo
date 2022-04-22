package raxcl.sort.count.review;

import java.util.Arrays;

/**
 * 计数排序复习4
 *
 * @author D30100_chenlong
 * @date 2022/4/21 9:58
 */
public class CountSortReview4 {
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
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]-min]++;
        }
        int index=0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                array[index++] = i+min;
            }
        }
    }
}
