package raxcl.structure.tree.allReview.binaryHeap;

import java.util.Arrays;

/**
 * 二叉堆的构建及上下浮动
 */
public class BinaryHeap {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }

    private static void buildHeap(int[] array) {
        // 从最后一个节点开始，依次做下沉调整
        for (int i = (array.length-2)/2; i >=0 ; i--) {
            downAdjust(array, i, array.length);
        }
    }

    private static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = parentIndex*2 +1;
        while(childIndex < length) {
            if (childIndex+1 <length  && array[childIndex] > array[childIndex + 1]) {
                childIndex++;
            }
            if (temp < array[childIndex]) {
                break;
            }

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2 +1;
        }
        array[parentIndex] = temp;

    }

    /**
     * 上浮调整
     * @param array
     */
    private static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) /2;
        // temp 保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) /2;
        }
        array[childIndex] = temp;
    }


}
