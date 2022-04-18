package raxcl.math;

import raxcl.swap.Swap;

/**
 * 找到整数所有全排列的下一个数
 *
 * @author D30100_chenlong
 * @date 2022/4/17 19:39
 */
public class FindNearestNumber {
    public static void main(String[] args) {
        System.out.println(findNearestNumber(17231));
    }

    private static int findNearestNumber(int number) {
        //找到逆序区域
        String str = String.valueOf(number);
        int[] array = new int[str.length()];

        for (int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            String s = String.valueOf(c);
            array[i] = Integer.parseInt(s);
        }
        int border = 0;
        for (int i=array.length-1; i>0; i--){
            if (array[i]>array[i-1]){
                border = i-1;
                break;
            }
        }
        //区域外和区域内最小元素交换
        int min = array.length-1;
        for (int i=border+1; i<array.length; i++){
            if (array[i]<array[min]){
                min = i;
            }
        }
        Swap.swap(array,border,min);
        //逆序区域重新排序(顺序）
        for (int i = border+1; i < array.length-1; i++) {
            for (int j = border+1; j < array.length-1; j++) {
                if (array[j]>array[j+1]){
                    Swap.swap(array,j,j+1);
                }
            }
        }
        //输出
        int result = 0;
        for (int a:array){
            result = result*10 +a;
        }
        return result;
    }
}
