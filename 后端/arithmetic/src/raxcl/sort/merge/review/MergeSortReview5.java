package raxcl.sort.merge.review;

import java.util.Arrays;

/**
 * 归并排序复习5
 *
 * @author D30100_chenlong
 * @date 2022-05-25 14:57:03
 */
public class MergeSortReview5 {
    public static void main(String[] args) {
        int[] array = {5,8,6,3,9,2,1,7};
        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int start, int end) {
        if(start<end){
            int mid = start + (end-start)/2;
            mergeSort(array,start, mid);
            mergeSort(array,mid+1, end);
            merge(array, start, mid, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int p1 = start;
        int p2 = mid+1;
        int res = 0;
        int[] resultArray = new int[end-start+1];
        while(p1<=mid && p2<=end){
            if (array[p1]<=array[p2]){
                resultArray[res++] = array[p1++];
            }else{
                resultArray[res++] = array[p2++];
            }
        }
        while(p1<=mid){
            resultArray[res++] = array[p1++];
        }
        while(p2<=end){
            resultArray[res++] = array[p2++];
        }
        System.arraycopy(resultArray,0,array,start,resultArray.length);


    }


}
