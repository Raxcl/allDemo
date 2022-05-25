package raxcl.search.review;

/**
 * 二分搜索复习1
 *
 * @author D30100_chenlong
 * @date 2022/5/9 17:48
 */
public class BinarySearchReview1 {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = i;
        }
        System.out.println(binarySearch(array,173));
    }
    private static int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length-1;
        //这里是什么值？
        int mid;
        while (start<=end){
            mid = start + (end-start)/2;
            if (target==mid){
                return mid;
            }else if (target<mid){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
}
