package raxcl.structure.tree.binaryHeap.review;

/**
 * 优先队列复习2
 *
 * @author D30100_chenlong
 * @date 2022/4/14 10:48
 */
public class PriorityQueue2 {
    private int[] array;
    private int size;
    public PriorityQueue2(){
        array = new int[32];
    }

    public static void main(String[] args) {
        PriorityQueue2 queue = new PriorityQueue2();
        //入队
        queue.enQueue(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(7);
        queue.enQueue(4);
        //出队
        System.out.println(queue.deQueue());
    }

    private void enQueue(int key) {
        if (size>=array.length){
            //扩容
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    private void resize() {
        int newSize = array.length*2;
        array = new int[newSize];
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

    private int deQueue() {
        int result = 0;
        if (size>0){
            result = array[0];
            array[0] = array[--size];
            downAdjust(0);
        }
        return result;

    }

    private void downAdjust(int parentIndex) {
        int temp = array[parentIndex];
        int childIndex = parentIndex*2 +1;
        while(childIndex<size){
            if (childIndex+1<size && array[childIndex+1]<array[childIndex]){
                childIndex++;
            }
            if (temp<array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2 +1;
        }
        array[parentIndex] = temp;

    }

}
