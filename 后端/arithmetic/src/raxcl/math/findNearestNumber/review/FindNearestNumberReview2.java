package raxcl.math.findNearestNumber.review;

import raxcl.swap.Swap;

/**
 * 寻找全排列的下一个数复习2
 *
 * @author D30100_chenlong
 * @date 2022/4/21 10:54
 */
public class FindNearestNumberReview2 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,4,3,2,1};
        numbers = findNearestNumber(numbers);
        for (int i:numbers){
            System.out.print(i);
        }
    }

    private static int[] findNearestNumber(int[] numbers) {
        int index=0;
        for (int i = numbers.length-1; i > 0; i--) {
            if (numbers[i]>numbers[i-1]){
                index = i-1;
                break;
            }
        }
        for (int i = numbers.length-1; i > index; i--) {
            if (numbers[index]<numbers[i]){
                Swap.swap(numbers, index,i);
                break;
            }
        }
        for (int i = index+1; i < numbers.length-1; i++) {
            for (int j = index+1; j < numbers.length-1; j++) {
                if(numbers[j]>numbers[j+1]){
                    Swap.swap(numbers,j,j+1);
                }
            }
        }
        return numbers;
    }
}
