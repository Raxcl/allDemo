package raxcl.sort.shell.review;

import java.util.Arrays;

/**
 * @author Raxcl
 * @date 2023/2/12 19:33
 */
public class ShellSortAllReview {
    public static void main(String[] args) {
        int[] array = {5,3,9,12,6,1,7,2,4,11,8,10};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void shellSort(int[] array) {
        int d = array.length;

        while (d>1) {
            d = d/2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i +=d) {
                    int temp = array[i];
                    int j=i-d;
                    for (;j>=0 && array[j] > temp; j = j-d){
                        array[j+d] = array[j];
                    }
                    array[j+d] = temp;
                }
            }
        }
    }

}
