package raxcl.math.findNearestNumber;

import raxcl.swap.Swap;

/**
 * 找到整数所有全排列的下一个数
 *
 * @author D30100_chenlong
 * @date 2022/4/17 19:39
 */
public class FindNearestNumber {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,4,3,2,1};
        numbers = findNearestNumber(numbers);
        for (int i:numbers){
            System.out.print(i);
        }
    }
    private static int[] findNearestNumber(int[] numbers) {
        //从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int index = 0;
        for (int i = numbers.length-1; i >0 ; i--) {
            if (numbers[i]>numbers[i-1]){
                index = i-1;
                break;
            }
        }
        //如果数字置换边界是0，说明整个数组已经逆序，无法得到更大的相同数
        if (index == 0 ){
            return null;
        }
        //把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
        for (int i=numbers.length-1; i>0; i--){
            if(numbers[index]<numbers[i]){
                Swap.swap(numbers,index,i);
                break;
            }
        }
        //把原来的逆序区域转为顺序
        for (int i=index+1; i<numbers.length-1; i++){
            for (int j=index+1; j<numbers.length-1; j++){
                if (numbers[j]>numbers[j+1]){
                    Swap.swap(numbers,j,j+1);
                }
            }
        }
        return numbers;
    }
}
