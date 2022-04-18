package raxcl.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 实现栈，记录最小值
 *
 * @author D30100_chenlong
 * @date 2022/4/16 14:06
 */
public class MinStack {
    private Deque<Integer> mainStack = new LinkedList<>();
    private Deque<Integer> minStack = new LinkedList<>();

    public void push(int element) {
        mainStack.push(element);
        if (minStack.isEmpty() || element <= minStack.peek()){
            minStack.push(element);
        }
    }

    public int pop() {
        if (mainStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        return mainStack.pop();
    }

    public int getMin(){
        if (!mainStack.isEmpty()){
           return minStack.peek();
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }

}
