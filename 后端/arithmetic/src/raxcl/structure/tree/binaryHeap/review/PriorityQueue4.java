package raxcl.structure.tree.binaryHeap.review;

import java.util.Arrays;

/**
 * 优先队列4
 *
 * @author D30100_chenlong
 * @date 2022/4/19 11:11
 */
public class PriorityQueue4 {
    int size;
    int[] array;
    public PriorityQueue4(){
        array = new int[32];
    }

    public static void main(String[] args) {
        PriorityQueue4 queue = new PriorityQueue4();
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
        int number = array[0];
        downAdjust(0);
        return number;
    }

    private void enQueue(int number) {
        if (size>=array.length){
            resize();
        }
        array[size++] = number;
        upAdjust();
    }

    private void resize() {
        int newSize = array.length*2;
        array = Arrays.copyOf(array,newSize);
    }

    private void downAdjust(int parentIndex) {
        int childIndex = parentIndex*2 +1;
        int temp = array[parentIndex];
        while (childIndex<size){
            if (childIndex+1<size && array[childIndex+1]<array[childIndex]){
                childIndex++;
            }
            if (array[childIndex]>temp){
                return;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2 +1;
        }
        array[parentIndex] = temp;
    }

    private void upAdjust() {
        //上浮
        int childIndex = size-1;
        int parentIndex = (childIndex-1)/2;
        int temp = array[childIndex];
        while(childIndex>0 && temp<array[parentIndex]){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
        array[childIndex] = temp;
    }
}
