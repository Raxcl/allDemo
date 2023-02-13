package raxcl.stack.review;


import raxcl.stack.review.MinStackAllReview;

import java.util.Deque;
import java.util.LinkedList;

public class MinStackAllReview {
    private Deque<Integer> mainStack = new LinkedList<>();
    private Deque<Integer> minStack = new LinkedList<>();

    public void push(int element) {
        mainStack.push(element);
        if (minStack.isEmpty() || minStack.peek() >= element) {
            minStack.push(element);
        }
    }

    public int pop() {
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    public int getMin(){
        if (!mainStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        MinStackAllReview stack = new MinStackAllReview();
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
