package raxcl.math.findNearestNumber.review;

import raxcl.swap.Swap;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Raxcl
 * @date 2023/2/12 18:27
 */
public class FindNearestNumberAllReview {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,4,3,2,1};
        numbers = findNearestNumber(numbers);
        for (int i:numbers){
            System.out.print(i);
        }
    }

    private static int[] findNearestNumber(int[] numbers) {
        int index = 0;
        for (int i = numbers.length -1; i > 0 ; i--) {
            if (numbers[i] > numbers[i-1]) {
                index = i-1;
                break;
            }
        }
        if (index == 0) return null;
        for (int i = numbers.length -1; i > index ; i--) {
            if (numbers[i] > numbers[index]) {
                Swap.swap(numbers, i, index);
                break;
            }
        }
        Arrays.sort(numbers, index+1, numbers.length );
        return numbers;
    }
}
