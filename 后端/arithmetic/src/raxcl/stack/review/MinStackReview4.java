package raxcl.stack.review;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈实现复习4
 *
 * @author D30100_chenlong
 * @date 2022-04-26 12:01:53
 */
public class MinStackReview4 {
    private Deque<Integer> mainStack = new LinkedList<>();
    private Deque<Integer> minStack = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        MinStackReview4 stack = new MinStackReview4();
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
        int num = mainStack.pop();
        if (num == minStack.peek()){
            minStack.pop();
        }
        return num;
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
