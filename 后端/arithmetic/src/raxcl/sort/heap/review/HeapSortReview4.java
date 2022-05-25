package raxcl.sort.heap.review;

import raxcl.swap.Swap;

import java.util.Arrays;

/**
 * 堆排序复习4
 *
 * @author D30100_chenlong
 * @date 2022-05-09 11:19:14
 */
public class HeapSortReview4 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,6,111,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] array) {
        //构建堆（大顶堆）
        for (int i = (array.length-2)/2; i >=0 ; i--) {
            downAdjust(array,i,array.length);
        }
        //堆排序，0和末值交换，然后0下沉，那么第二大的就会出现在堆顶，重复步骤
        for (int i = array.length-1; i >=0 ; i--) {
            Swap.swap(array,0, i);
            downAdjust(array, 0, i);
        }
    }

    private static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = parentIndex*2+1;
        while(childIndex<length){
            if (childIndex+1<length && array[childIndex+1]>array[childIndex]){
                childIndex++;
            }
            if (temp>array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2+1;
        }
        array[parentIndex] = temp;
    }



}
