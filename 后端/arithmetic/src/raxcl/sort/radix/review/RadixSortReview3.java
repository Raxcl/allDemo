package raxcl.sort.radix.review;

import java.util.Arrays;

/**
 * 基数排序复习3
 *
 * @author D30100_chenlong
 * @date 2022-04-29 12:03:53
 */
public class RadixSortReview3 {
    public static void main(String[] args) {
        String[] array = {"qd","abc","qwe","hhh","a","cws","ope"};
        System.out.println(Arrays.toString(radixSort(array,3)));
    }


    private static String[] radixSort(String[] array, int maxLength) {
        for(int x=maxLength-1; x>=0; x--){
            int[] countArray = new int[128];
            for (String s : array) {
                int num = (x + 1) <= s.length() ? s.charAt(x) : 0;
                countArray[num]++;
            }

            for (int i = 1; i < countArray.length; i++) {
                countArray[i] += countArray[i-1];
            }
            String[] tempResult = array.clone();
            for (int i=tempResult.length-1; i>=0; i--){
                int num = (x+1)<=tempResult[i].length()? tempResult[i].charAt(x): 0;
                int a = countArray[num]-- -1;
                array[a] = tempResult[i];
                //qd abc qwe hhh a cws ope
                //qd a abc que ope hhh cws
            }

        }
        return array;
    }

}
