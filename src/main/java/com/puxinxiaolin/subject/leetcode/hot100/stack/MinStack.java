package com.puxinxiaolin.subject.leetcode.hot100.stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> minStack;
    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * 1. 辅助栈入栈
     * 2. 当 最小栈为空 或 最小栈的栈顶元素 >= 当前元素，才会入栈
     *
     * @param val
     */
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    /**
     * 1. 辅助栈弹出一个元素
     * 2. 当 弹出的元素 == 最小栈的栈顶元素，则最小栈也弹出一个元素
     */
    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
