package raxcl.search.review;

/**
 * 二分搜索复习3
 *
 * @author D30100_chenlong
 * @date 2022-05-19 11:11:14
 */
public class BinarySearchReview3 {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = i;
        }
        System.out.println(binarySearch(array,173));
    }
    private static int binarySearch(int[] array, int target) {
        int left = array[0];
        int right = array[array.length-1];
        int mid ;
        while(left<=right){
            mid = left + (right-left)/2;
            if (target==mid){
                return mid;
            }else if (target>mid){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
}
