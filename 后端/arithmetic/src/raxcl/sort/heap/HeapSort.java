package raxcl.sort.heap;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author D30100_chenlong
 * @date 2022/4/14 13:00
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] array) {
        //1. 把无序数组构建成最大堆
        for (int i = (array.length-2)/2; i>=0; i--){
            downAdjust(array, i, array.length);
        }
        //2. 循环删除堆顶元素，移到集合尾部，调整堆产生新的堆顶
        for (int i=array.length-1; i>0; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            //下沉调整最大堆
            downAdjust(array, 0, i);
        }
    }

    public static void downAdjust(int[] array, int parentIndex , int length){
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
