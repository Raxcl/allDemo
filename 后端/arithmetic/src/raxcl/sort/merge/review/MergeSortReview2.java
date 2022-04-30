package raxcl.sort.merge.review;

import java.util.Arrays;

/**
 * 归并排序复习2
 *
 * @author D30100_chenlong
 * @date 2022/4/22 16:19
 */
public class MergeSortReview2 {
    public static void main(String[] args) {
        int[] array = {5,8,6,3,9,2,1,7};
        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start<end){
            int mid = (start+end)/2;
            mergeSort(array,start,mid);
            mergeSort(array,mid+1,end);
            merge(array,start,mid,end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int pos1 = start;
        int pos2 = mid+1;
        int[] result = new int[end-start+1];
        int res = 0;
        while (pos1<=mid && pos2<=end){
            if (array[pos1]>array[pos2]){
                result[res++] = array[pos2++];
            }else{
                result[res++] = array[pos1++];
            }
        }
        while (pos1<=mid){
            result[res++] = array[pos1++];
        }
        while (pos2<=end){
            result[res++] = array[pos2++];
        }
        System.arraycopy(result,0,array,start,result.length);
    }


}
