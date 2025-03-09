package com.puxinxiaolin.subject.leetcode.hot100.stack;

import org.junit.jupiter.api.Test;

class MinStackTest {

    private MinStack minStack = new MinStack();

    @Test
    void testMinStack() {
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}