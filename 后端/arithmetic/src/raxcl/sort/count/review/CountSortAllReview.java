package raxcl.sort.count.review;

import java.util.Arrays;

/**
 * @author Raxcl
 * @date 2023/2/12 20:06
 */
public class CountSortAllReview {
    public static void main(String[] args) {
        int[] array = new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] countSort(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int d = max - min;
        int[] countArray = new int[d+1];
        for (int a: array) {
            countArray[a-min]++;
        }
        for (int i=1; i<countArray.length; i++) {
            countArray[i] += countArray[i-1];
        }
        int[] sortedArray = new int[array.length];
        for (int i = array.length-1; i >=0 ; i--) {
            sortedArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i]-min]--;
        }
        return sortedArray;
    }
}
