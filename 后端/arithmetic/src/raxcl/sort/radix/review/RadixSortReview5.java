package raxcl.sort.radix.review;

import java.util.Arrays;

/**
 * 基数排序复习5
 *
 * @author D30100_chenlong
 * @date 2022-05-30 16:03:09
 */
public class RadixSortReview5 {
    public static void main(String[] args) {
        String[] array = {"qd","abc","qwe","hhh","a","cws","ope"};
        System.out.println(Arrays.toString(radixSort(array,3)));
    }


    private static String[] radixSort(String[] array, int maxLength) {
        for (int k = maxLength-1; k >= 0; k --) {
            int[] countArray = new int[128];
            for (String s : array) {
                int num = k > s.length() - 1 ? 0 : s.charAt(k);
                countArray[num]++;
            }
            for (int i = 1; i < countArray.length; i++) {
                countArray[i] += countArray[i-1];
            }
            String[] result = new String[array.length];
            for (int i = array.length-1; i >=0 ; i--) {
                int num = k > array[i].length() - 1 ? 0 : array[i].charAt(k);
                result[countArray[num]-- -1] = array[i];
            }
            array = result.clone();
        }
        return array;
    }

}
