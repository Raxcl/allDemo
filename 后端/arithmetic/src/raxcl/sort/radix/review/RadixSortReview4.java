package raxcl.sort.radix.review;

import java.util.Arrays;

/**
 * 基数排序复习4
 *
 * @author D30100_chenlong
 * @date 2022-05-17 14:23:10
 */
public class RadixSortReview4 {
    public static void main(String[] args) {
        String[] array = {"qd","abc","qwe","hhh","a","cws","ope"};
        System.out.println(Arrays.toString(radixSort(array,3)));
    }


    private static String[] radixSort(String[] array, int maxLength) {
        for (int k = maxLength-1; k >=0 ; k--) {
            int[] countArray = new int[128];
            for (String s: array){
                int num = k+1<=s.length()? s.charAt(k) : 0;
                countArray[num]++;
            }
            for (int i = 1; i < countArray.length; i++) {
                countArray[i] += countArray[i-1];
            }
            String[] tempArray = new String[array.length];
            for (int i = array.length-1; i >= 0; i--) {
                int num = k+1<=array[i].length()? array[i].charAt(k) : 0;
                tempArray[countArray[num]-- -1] = array[i];
            }
            array = tempArray.clone();
        }
        return array;
    }

}
