package raxcl.sort.heap.review;

import raxcl.swap.Swap;

import java.util.Arrays;

/**
 * 堆排序复习2
 *
 * @author D30100_chenlong
 * @date 2022-04-26 11:21:21
 */
public class HeapSortReview2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] array) {
        //构建堆，叶子每个都下沉（大顶堆）
        for (int i = (array.length-2)/2; i >=0 ; i--) {
            downAdjust(array, i, array.length);
        }
        //删除顶部（和堆底交换位置）
        //不把i包括在内，因为i已经是最大值了
        for (int i = array.length-1; i >= 0; i--) {
            Swap.swap(array,0, i);
            downAdjust(array, 0, i);
        }
    }

    private static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = parentIndex*2 +1;
        while(childIndex<length){
            if (childIndex+1<length && array[childIndex+1]>array[childIndex]){
                childIndex++;
            }
            if (temp>array[childIndex]){
                return;
            }
            array[parentIndex] = array[childIndex];
            parentIndex =childIndex;
            childIndex = parentIndex*2 +1;
        }
        array[parentIndex] = temp;
    }


}
