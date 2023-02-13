package raxcl.sort.radix.review;

import java.util.Arrays;

/**
 * @author Raxcl
 * @date 2023/2/12 20:23
 */
public class RadixSortReviewAll {
    public static void main(String[] args) {
        String[] array = {"qd","abc","qwe","hhh","a","cws","ope"};
        System.out.println(Arrays.toString(radixSort(array,3)));
    }

    private static String[] radixSort(String[] array, int maxLength) {
        String[] sortedArray = new String[array.length];
        for (int k = maxLength-1; k>=0; k--) {
            int[] count = new int[128];
            for (int i = 0; i < array.length; i++) {
                int index = getCharIndex(array[i], k);
                count[index]++;
            }
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i-1];
            }
            for (int i=array.length-1; i>=0;i--) {
                int index = getCharIndex(array[i], k);
                int sortedIndex = count[index] - 1;
                sortedArray[sortedIndex] = array[i];
                count[index]--;
            }
            array = sortedArray.clone();
        }

        return array;
    }

    private static int getCharIndex(String str, int k) {
        if (str.length()-1 < k){
            return 0;
        }
        return str.charAt(k);

    }
}
