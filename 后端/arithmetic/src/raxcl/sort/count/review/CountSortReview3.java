package raxcl.sort.count.review;

import java.util.Arrays;

/**
 * 计数排序复习3
 *
 * @author D30100_chenlong
 * @date 2022-04-29 11:39:47
 */
public class CountSortReview3 {
    public static void main(String[] args) {
        int[] array = new int[] {4,4,6,5,3,2,8,1,7,5,6,0,10};
        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] countSort(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int d = max-min;
        int[] countArray = new int[d+1];
        for(int num: array){
            countArray[num-min]++;
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i-1];
        }
        int[] result = new int[array.length];
        for (int i=array.length-1; i>=0; i--){
            result[countArray[array[i]-min]-- -1] = array[i];
        }
        return result;
    }
}
