package raxcl.sort.heap.review;

import raxcl.swap.Swap;

import java.util.Arrays;

/**
 * @author Raxcl
 * @date 2023/2/12 19:18
 */
public class HeapSortAllReview {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] array) {
        for (int i = (array.length-2)/2; i >=0 ; i--) {
            downAdjust(array,i,array.length);
        }

        for (int i = array.length - 1; i >0 ; i--) {
            Swap.swap(array,0,i);
            downAdjust(array,0,i);
        }
    }

    private static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = parentIndex*2 +1;
        while(childIndex<length){
            if(childIndex+1<length && array[childIndex+1] > array[childIndex] ){
                childIndex++;
            }
            //如果父节点小于任何一个子节点则跳出
            if(temp > array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2 +1;
        }
        array[parentIndex] = temp;

    }


}
