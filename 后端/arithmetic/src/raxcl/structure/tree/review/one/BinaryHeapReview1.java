package raxcl.structure.tree.review.one;

import java.util.Arrays;


/**
 * 二叉堆和优先队列复习
 *
 * @author D30100_chenlong
 * @date 2022/4/13 9:34
 */
public class BinaryHeapReview1 {


    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};
        //上浮
        upAdjust(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{7,1,3,10,5,2,8,9,6};
        //构建堆
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
    private static void upAdjust(int[] array) {
        int childIndex = array.length-1;
        int parentIndex = (childIndex-1)/2;
        int temp = array[childIndex];
        while (childIndex>0 && temp<array[parentIndex]){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
        array[childIndex] = temp;
    }

    private static void buildHeap(int[] array) {
        int childIndex = (array.length-2)/2;
        for (int i=childIndex;i>=0;i--){
            downAdjust(array,i);
        }
    }

    private static void downAdjust(int[] array, int parentIndex) {
        int childIndex = parentIndex*2 +1;
        int temp = array[parentIndex];
        while(childIndex<array.length){
            if (childIndex+1<array.length && array[childIndex+1] < array[childIndex]){
                childIndex++;
            }
            if (temp < array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2 +1;
        }
        array[parentIndex] = temp;
    }


}
