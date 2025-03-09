package com.puxinxiaolin.subject.leetcode.easyStart;

public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree2(27));
        System.out.println(!isPowerOfThree2(0));
        System.out.println(isPowerOfThree2(9));
        System.out.println(!isPowerOfThree2(45));
    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 3 == 0) {
            return isPowerOfThree(n / 3);
        } else {
            return false;
        }
    }

    public static boolean isPowerOfThree2(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
