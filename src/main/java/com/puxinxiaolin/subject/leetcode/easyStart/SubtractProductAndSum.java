package com.puxinxiaolin.subject.leetcode.easyStart;

public class SubtractProductAndSum {
    public static int subtractProductAndSum(int n) {
        int multiple = 1, sum = 0;
        while (n > 0) {
            multiple *= n % 10;
            sum += n % 10;
            n /= 10;
        }
        return multiple - sum;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234) == 15);
        System.out.println(subtractProductAndSum(4421) == 21);
    }
}
