package com.puxinxiaolin.subject.dynamicProgramming.leetcode.greedy;

import java.util.Scanner;

public class ZeroOneBag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bagWeight = sc.nextInt();

        int[] w = new int[n];
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }

        int[][] dp = new int[n][bagWeight + 1];
        for (int i = w[0]; i <= bagWeight; i++) {
            dp[0][i] = v[0];
        }
    }
}
