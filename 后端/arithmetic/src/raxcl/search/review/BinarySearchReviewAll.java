package raxcl.search.review;

/**
 * @author Raxcl
 * @date 2023/2/12 22:50
 */
public class BinarySearchReviewAll {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = i;
        }
        System.out.println(binarySearch(array,173));

        int start = 0;
        int end = array.length - 1;

        System.out.println(binarySearch1(array,start,end,173));
    }

    private static int binarySearch1(int[] array, int start, int end, int target) {
        if (start<0 || end >=array.length) return -1;
        int mid = start + ((end - start)>>1);
        if (array[mid] == target) return mid;
        else if(array[mid] < target) return binarySearch1(array,mid +1,end,173);
        else return binarySearch1(array,start,mid - 1,173);
    }

    private static int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        int mid;

        while (start<=end) {
            mid = start + ((end - start)>>1);
            if (array[mid] == target) return mid;
            else if(array[mid] < target) start = mid +1;
            else end = mid - 1;
        }
        return -1;

    }


}
