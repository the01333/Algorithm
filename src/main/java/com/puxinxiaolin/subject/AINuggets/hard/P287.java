package com.puxinxiaolin.subject.AINuggets.hard;

import java.util.LinkedList;

public class P287 {
    public static boolean solution(int n, int[] a, int[] b) {
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0, j = 0;
        while (i < n) {
            stack.push(a[i++]);
            // 每次压入一个元素后去比较 b 里的当前位置是否相等，如果相等直接弹出并且往后移
            while (!stack.isEmpty() && stack.peek() == b[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{1, 2, 3}, new int[]{1, 2, 3}));
        System.out.println(solution(3, new int[]{1, 2, 3}, new int[]{3, 2, 1}));
        System.out.println(!solution(3, new int[]{1, 2, 3}, new int[]{3, 1, 2}));
    }
}
