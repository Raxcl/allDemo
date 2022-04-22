package raxcl.math.findNearestNumber.review;

import raxcl.swap.Swap;

/**
 * 寻找全排序的下一个数复习1
 *
 * @author D30100_chenlong
 * @date 2022/4/20 13:35
 */
public class FindNearestNumberReview1 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,4,3,2,1};
        numbers = findNearestNumber(numbers);
        for (int i:numbers){
            System.out.print(i);
        }
    }

    private static int[] findNearestNumber(int[] numbers) {
        //得到逆序区域的下一个数index
        int index = 0;
        for (int i = numbers.length-1; i >0; i--) {
            if (numbers[i]>numbers[i-1]){
                index = i-1;
                break;
            }
        }
        if (index==0){
            return null;
        }
        //index与逆序区域内比它大的数交换
        for (int i = numbers.length-1; i >index; i--) {
            if (numbers[index]<numbers[i]){
                Swap.swap(numbers,index,i);
                break;
            }
        }
        //逆序区域排序
        for (int i = index+1; i <numbers.length-1; i++) {
            for (int j = index+1; j <numbers.length-1; j++) {
                if (numbers[j]>numbers[j+1]){
                    Swap.swap(numbers,j,j+1);
                }
            }
        }
        return numbers;
    }
}
