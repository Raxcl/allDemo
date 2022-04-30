package raxcl.math.findNearestNumber.review;

import raxcl.swap.Swap;

/**
 * 寻找全排列的下一个数复习3
 *
 * @author D30100_chenlong
 * @date 2022-04-26 11:44:31
 */
public class FindNearestNumberReview3 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,4,3,2,1};
        numbers = findNearestNumber(numbers);
        for (int i:numbers){
            System.out.print(i);
        }
    }

    private static int[] findNearestNumber(int[] numbers) {
        //寻找逆序区域外边界
        int border = 0;
        for (int i=numbers.length-1; i>0;i--){
            if (numbers[i]>numbers[i-1]){
                border = i-1;
                break;
            }
        }
        //和逆序区域仅大于它的数交换
        for (int i=numbers.length-1; i>0;i--){
            if (numbers[border]<numbers[i]){
                Swap.swap(numbers,border, i);
                break;
            }
        }
        //逆序转正序
        int index=0;
        for (int i = border+1; i < numbers.length-1; i++) {
            for (int j = border+1; j < numbers.length-1-index; j++) {
                if (numbers[j]>numbers[j+1]){
                    Swap.swap(numbers,j,j+1);
                }
            }
            index++;
        }
        return numbers;
    }
}
