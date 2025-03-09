package com.puxinxiaolin.subject.leetcode.easyStart;

public class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(!isPowerOfTwo(3));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }
        if (n % 2 == 1) {
            return false;
        } else {
            return isPowerOfTwo(n / 2);
        }
    }
}
