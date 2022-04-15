package raxcl.structure.tree.review.one;

import java.util.Arrays;

/**
 * 优先队列复习1
 *
 * @author D30100_chenlong
 * @date 2022/4/13 10:34
 */
public class PriorityQueue1 {
    private int[] array;
    private int size;
    public PriorityQueue1(){
        array = new int[32];
    }


    public static void main(String[] args) {
//        //优先队列（就是最大堆和最小堆），这里为了方便用最小堆
//        //删除
        PriorityQueue1 queue = new PriorityQueue1();
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
        int head = 0;
        if(size>0){
            head = array[0];
            array[0] = array[--size];
            downAdjust(0);
        }
        return head;
    }

    private void enQueue(int key) {
        if(size>=array.length){
            resize();
        }
        array[size++] = key;
        upAdjust();
    }


    private void resize() {
        int newSize = array.length*2;
        array = Arrays.copyOf(array, newSize);
    }

    private void upAdjust() {
        int childIndex = size-1;
        int parentIndex = (childIndex-1)/2;
        int temp = array[childIndex];
        while (childIndex>0 && temp<array[parentIndex]){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
        array[childIndex] = temp;
    }

    private void downAdjust(int parentIndex) {
        int childIndex = parentIndex*2 +1;
        int temp = array[parentIndex];
        while(childIndex<size){
            if (childIndex+1<size && array[childIndex+1] < array[childIndex]){
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
