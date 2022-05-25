package raxcl.math;

import raxcl.swap.Swap;

/**
 * 寻找第k大的元素
 *
 * @author D30100_chenlong
 * @date 2022/5/23 16:18
 */
public class KthLargestNumber {
    public static void main(String[] args) {     // 6
        int[] array = new int[]{7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8};
        System.out.println(findKthLargestNumber1(array, 6));
    }

    //分治法
    private static int findKthLargestNumber1(int[] array, int k) {
        // 最终目的:array.length-k = 基准值;
        // 取下标1作为基值分治,检查基准值位置
        // 如果小于目标值，取右边一个元素分治，如果大了，取左边一个元素分治
        int start = 0;
        int end = array.length-1;
        int target = array.length-k;
        while (true){
            int partition = divide(array,start, end);
            if (partition == target){
                return array[partition];
            }else if(partition< target){
                start = partition+1;
            }else{
                end = partition-1;
            }
        }

    }

    private static int divide(int[] array, int start, int end) {
        int pivot = array[start];
        int mark = start+1;
        for (int i = start+1; i <= end; i++) {
            if (array[i]<pivot && i!=mark){
                Swap.swap(array,i,mark++);
            }
        }
        Swap.swap(array,start,--mark);
        return mark;
    }

    //小顶堆法
    private static int findKthLargestNumber(int[] array, int k) {
        //构建小顶堆，长度为6
        buildHeap(array, k);
        //遍历剩余数组，如果大于堆顶，替换堆顶，下沉
        for (int i=k; i<array.length; i++){
            if (array[i]>array[0]){
                array[0] = array[i];
                downAdjust(array, 0, k);
            }
        }
        //输出堆顶
        return array[0];
    }

    private static void buildHeap(int[] array, int length) {
        //非叶子节点依次下沉
        for (int i=(length-2)/2; i>=0; i--){
            downAdjust(array, i, length);
        }
    }

    private static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = parentIndex*2+1;
        //理解下为什么是6,因为符合正常逻辑，保证全部遍历，不会溢出
        while (childIndex<length){
            if (childIndex+1<length && array[childIndex+1]<array[childIndex]){
                childIndex++;
            }
            if (temp<array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2+1;
        }
        array[parentIndex] = temp;
    }
}
