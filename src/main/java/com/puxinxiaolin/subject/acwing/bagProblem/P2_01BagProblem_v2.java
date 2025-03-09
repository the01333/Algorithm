package com.puxinxiaolin.subject.acwing.bagProblem;

import java.util.Scanner;

/**
 * @Description: 01背包（一维数组优化）
 * @Author: YccLin
 * @Date: 2024/12/3
 */
public class P2_01BagProblem_v2 {
    /**
     @Input:
     4 5
1 2
2 4
3 4
4 5
     @Ouput:
     8
     */
    static int N = 1010;
    static int n, m;
    static int[] dp = new int[N];   // 前 i 个物品的最大价值
    static int[] v = new int[N];
    static int[] w = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
               dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }

        System.out.println(dp[m]);
    }
}
