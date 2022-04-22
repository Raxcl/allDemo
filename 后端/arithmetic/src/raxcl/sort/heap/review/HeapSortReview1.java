package raxcl.sort.heap.review;

import raxcl.swap.Swap;

import java.util.Arrays;

/**
 * 堆排序复习1
 *
 * @author D30100_chenlong
 * @date 2022/4/22 14:38
 */
public class HeapSortReview1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] array) {
        //将无序数组构建成大顶堆
        for (int i = (array.length-2)/2; i >=0 ; i--) {
            downAdjust(array,i,array.length);
        }
        //不断删除最后一个（交换位置），然后下沉
        for (int i=array.length-1; i>=0; i--){
            Swap.swap(array,i,0);
            //下沉
            downAdjust(array,0,i);
        }
    }

    private static void downAdjust(int[] array, int parentIndex, int length) {
        int childIndex = parentIndex*2+1;
        int temp = array[parentIndex];
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
