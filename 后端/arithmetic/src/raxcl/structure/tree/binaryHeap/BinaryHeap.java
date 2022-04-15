package raxcl.structure.tree.binaryHeap;

import java.util.Arrays;

/**
 * 二叉堆的构建及上下浮
 *
 * @author D30100_chenlong
 * @date 2022/4/11 15:48
 */
public class BinaryHeap {
    /**
     * 上浮调整
     * @param array
     */
    public static void upAdjust(int[] array){
        int childIndex = array.length - 1;
        int parentIndex = (childIndex-1)/2;
        //temp 保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        while(childIndex >0 && temp< array[parentIndex]){
            //无须真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉调整
     * @param array 待调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex , int length){
        int temp = array[parentIndex];
        int childIndex = parentIndex*2 +1;
        while(childIndex<length){
            if(childIndex+1<length && array[childIndex+1] < array[childIndex] ){
                childIndex++;
            }
            //如果父节点小于任何一个子节点则跳出
            if(temp < array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2 +1;
        }
        array[parentIndex] = temp;
    }

    public static void buildHeap(int[] array){
        //从最后一个非叶子节点开始，依次做下沉调整
        for(int i = (array.length-2)/2; i>=0; i--){
            downAdjust(array,i,array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
