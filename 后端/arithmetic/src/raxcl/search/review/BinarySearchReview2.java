package raxcl.search.review;

/**
 * 二分搜索复习2
 *
 * @author D30100_chenlong
 * @date 2022-05-16 11:38:29
 */
public class BinarySearchReview2 {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = i;
        }
        System.out.println(binarySearch(array,173));
    }
    private static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if (mid == target){
                return mid;
            }else if (target < mid){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}
