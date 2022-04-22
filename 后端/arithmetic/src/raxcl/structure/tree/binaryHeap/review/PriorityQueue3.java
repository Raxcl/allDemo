package raxcl.structure.tree.binaryHeap.review;

import java.util.Arrays;

/**
 * 优先队列3
 *
 * @author D30100_chenlong
 * @date 2022/4/16 10:02
 */
public class PriorityQueue3 {
    int size;
    int[] arr;
    public PriorityQueue3(){
        arr = new int[32];
    }

    public static void main(String[] args) {
        PriorityQueue3 queue = new PriorityQueue3();
        //入队
        queue.enQueue(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(7);
        queue.enQueue(4);
        //出队
        System.out.println(queue.deQueue());
    }

    private int deQueue() {
        int result = arr[0];
        arr[0] = arr[--size];
        downAdjust3(arr, 0);
        return result;
    }

    private void downAdjust3(int[] array, int parentIndex) {
        int childIndex = parentIndex*2 +1;
        int temp = array[parentIndex];
        while(childIndex<size){
            if (childIndex+1<size && array[childIndex+1]>array[childIndex]){
                childIndex++;
            }
            if (array[childIndex]<=temp){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2 +1;
        }
        array[parentIndex] = temp;
    }

    private void enQueue(int i) {
        if (size>=arr.length){
            resize();
        }
        arr[size++] = i;
        upAdjust3(arr);
    }

    private void upAdjust3(int[] array) {
        int childIndex = size-1;
        int parentIndex = (childIndex-1)/2;
        int temp =  array[childIndex];
        while(childIndex>0 && array[parentIndex]<temp){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
        array[childIndex] = temp;
    }

    private void resize() {
         int newSize = size;
        arr = Arrays.copyOf(arr,newSize);
    }
}
