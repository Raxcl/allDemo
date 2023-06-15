package raxcl.笔试;

/**
 * @author D30100_chenlong
 * @date 2023/3/18 0:44
 */
public class BinarySearch {
    public static void main(String[] args) {
        int search = search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5);
        System.out.println(search);
    }

    private static int search(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0, right = arr.length - 1, mid;
        while(left <= right) {
            mid = left + ((right - left) >> 1) ;
            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] < n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
