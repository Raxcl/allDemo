package raxcl.sort.radix.review;

import java.util.Arrays;

/**
 * 基数排序复习2
 *
 * @author D30100_chenlong
 * @date 2022-04-27 10:26:15
 */
public class RadixSortReview2 {
    public static void main(String[] args) {
        String[] array = {"qd","abc","qwe","hhh","a","cws","ope"};
        System.out.println(Arrays.toString(radixSort(array,3)));
    }

    private static String[] radixSort(String[] array, int maxLength) {
        for(int x=maxLength-1; x>=0; x--){
            int[] countArray = new int[128];
            for (String s : array) {
                int num = x+1 > s.length() ? 0 : s.charAt(x);
                countArray[num]++;
            }
            for (int i = 1; i < countArray.length; i++) {
                countArray[i] += countArray[i-1];
            }
            String[] result = new String[array.length];
            for(int i=array.length-1; i>=0; i--){
                int num = x+1 > array[i].length() ? 0 : array[i].charAt(x);
                result[countArray[num]-1] = array[i];
                countArray[num]--;
            }
            array = result.clone();
        }
        return array;
    }

}
