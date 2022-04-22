package raxcl.stack.review;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈实现
 *
 * @author D30100_chenlong
 * @date 2022/4/21 10:43
 */
public class MinStackReview3 {
    private Deque<Integer> mainStack = new LinkedList<>();
    private Deque<Integer> minStack = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        MinStackReview3 stack = new MinStackReview3();
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

    private int pop() {
        int number = mainStack.pop();
        if (minStack.peek() ==number){
            minStack.pop();
        }
        return number;
    }

    private int getMin() {
        return minStack.peek();
    }

    private void push(int number) {
        mainStack.push(number);
        if (minStack.isEmpty() || minStack.peek()>=number){
            minStack.push(number);
        }
    }
}
