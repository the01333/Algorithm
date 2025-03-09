package com.puxinxiaolin.subject.leetcode.common.dynamicProgramming;

public class Tribonacci {
    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(4) == 4);
        System.out.println(tribonacci(25) == 1389537);
    }
}
