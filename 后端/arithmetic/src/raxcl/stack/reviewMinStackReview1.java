package raxcl.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈复习1
 *
 * @author D30100_chenlong
 * @date 2022/4/18 10:29
 */
public class reviewMinStackReview1 {
    private Deque<Integer> mainStack = new LinkedList<>();
    private Deque<Integer> minStack = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        reviewMinStackReview1 stack = new reviewMinStackReview1();
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

    private int getMin() {
        return minStack.peek();
    }

    private int pop() {
        int number = mainStack.pop();
        if (number == minStack.peek()){
            minStack.pop();
        }
        return number;
    }

    private void push(int number) {
        mainStack.push(number);
        if (minStack.isEmpty() || minStack.peek()>=mainStack.peek()){
            minStack.push(number);
        }
    }
}
