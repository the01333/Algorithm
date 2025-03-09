package com.puxinxiaolin.subject.dynamicProgramming.leetcode;

public class P343_IntegerPartition {
    public static int integerBreak(int n) {
        /*
            dp[i]: 对 i 进行拆分 k 个后相乘得到的最大值
            i: 要拆分的数
         */
        int[] dp = new int[n + 1];
        dp[2] = 1;
        // 2 已经初始化过了，所以从 3 开始遍历
        for (int i = 3; i <= n; i++) {
            // i - j: 不包含重复的情况
            for (int j = 1; j <= i - j; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(2) == 1);
        System.out.println(integerBreak(10) == 36);
    }
}
