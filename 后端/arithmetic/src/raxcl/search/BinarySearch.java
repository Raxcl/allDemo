package raxcl.search;

/**
 * 二分搜索
 *
 * @author D30100_chenlong
 * @date 2022/5/6 14:37
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = i;
        }
        System.out.println(binarySearch(array,173));
    }

    private static int binarySearch(int[] array, int target) {
        //查找范围起点
        int start = 0;
        //查找范围终点
        int end = array.length -1;
        //查找范围中位数
        int mid;

        while(start <= end){
            //mid=(start+end)/2 有可能溢出 ？？？
            //start+end有可能超过整数的最大值（10的23次方），就会溢出
            mid = start + (end - start)/2;
            if (array[mid] == target){
                return mid;
            }else if(array[mid]< target){
                start = mid +1;
            }else {
                end = mid-1;
            }
        }
        return -1;
    }
}
