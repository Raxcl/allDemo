package raxcl.swap;

/**
 * 交换
 *
 * @author D30100_chenlong
 * @date 2022/4/15 10:06
 */
public class Swap {
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
