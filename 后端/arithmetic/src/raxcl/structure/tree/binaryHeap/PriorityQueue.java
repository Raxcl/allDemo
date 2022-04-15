package raxcl.structure.tree.binaryHeap;

import java.util.Arrays;

/**
 * 优先队列
 *
 * @author D30100_chenlong
 * @date 2022/4/11 20:59
 */
public class PriorityQueue {
    private int[] array;
    private int size;
    public PriorityQueue(){
        //队列初始长度为32
        array = new int[32];
    }

    /**
     * 队列扩容
     */
    private void resize(){
        //队列容量翻倍
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array,newSize);
    }

    /**
     * 入队
     * @param key 入队元素
     */
    public void enQueue(int key){
        //队列长度超出范围，扩容
        if(size>=array.length){
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    /**
     * 出队
     */
    public int deQueue() throws Exception {
        if (size<=0){
            throw new Exception("the queue is empty!");
        }
        //获取堆顶元素
        int head = array[0];
        //让最后一个元素移动到堆顶
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    /**
     * 上浮调整
     */
    private void upAdjust(){
        int childIndex = size-1;
        int parentIndex = (childIndex-1)/2;
        //temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        while(childIndex > 0 && temp> array[parentIndex]){
            array[childIndex] = array[parentIndex];
            childIndex=parentIndex;
            parentIndex = (childIndex-1)/2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉调整
     */
    private void downAdjust(){
        int parentIndex = 0;
        int childIndex = parentIndex*2 +1;
        int temp = array[parentIndex];
        while(childIndex<size){
            //如果有右孩子，且右孩子大于左孩子，则定位到右孩子
            if (childIndex+1<size && array[childIndex+1] > array[childIndex]){
                childIndex++;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2 +1;
        }
        array[parentIndex] = temp;
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        System.out.println("出队元素："+ priorityQueue.deQueue());
        System.out.println("出队元素："+ priorityQueue.deQueue());
    }


}
