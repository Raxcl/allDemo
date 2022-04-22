package raxcl.sort.merge.review;

import raxcl.sort.merge.MergeSort;

import java.util.Arrays;

/**
 * 归并排序复习1
 *
 * @author D30100_chenlong
 * @date 2022/4/22 16:19
 */
public class MergeSortReview1 {
    public static void main(String[] args) {
        int[] array = {5,8,6,3,9,2,1,7};
        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int start, int end) {
        //不断划分到最小
        if (start<end){
            int mid = (start+end)/2;
            mergeSort(array, start, mid);
            mergeSort(array,mid+1, end);
            //开始归并
            merge(array,start, mid, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        //开辟额外大集合
        int[] tempArray = new int[end-start+1];
        int p=0;
        int p1=start;
        int p2=mid+1;
        while(p1<=mid && p2<=end){
            if (array[p1]<=array[p2]){
                tempArray[p++] = array[p1++];
            }else{
                tempArray[p++] = array[p2++];
            }
        }
        if (p1<=mid){
            System.arraycopy(array,p1,tempArray,p,mid-p1+1);
        }else if(p2<=end){
            System.arraycopy(array,p2,tempArray,p,end-p2+1);
        }
        System.arraycopy(tempArray,0,array,start,tempArray.length);

    }


}
