package raxcl.math.findNearestNumber.review;

import raxcl.swap.Swap;

/**
 * 寻找全排列的下一个数复习5
 *
 * @author D30100_chenlong
 * @date 2022-05-30 14:09:54
 */
public class FindNearestNumberReview5 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,4,3,2,1};
        numbers = findNearestNumber(numbers);
        for (int i:numbers){
            System.out.print(i);
        }
    }

    private static int[] findNearestNumber(int[] numbers) {
        int target = -1;
        for (int i = numbers.length-1; i >=0 ; i--) {
            if (numbers[i]>numbers[i-1]){
                target = i-1;
                break;
            }
        }

        for (int i = numbers.length-1; i >=0 ; i--) {
            if (numbers[target]<numbers[i]){
                Swap.swap(numbers, target, i);
                break;
            }
        }

        for (int i = target+1; i < numbers.length-1; i++) {
            for (int j = target+1; j < numbers.length-1; j++) {
                if (numbers[j]>numbers[j+1]){
                    Swap.swap(numbers,j,j+1);
                }
            }
        }


        return numbers;
    }
}
