package com.puxinxiaolin.subject.acwing.bagProblem;

import java.util.Scanner;

/**
 * @Description: 01背包（二维动态规划）
 * @Author: YccLin
 * @Date: 2024/12/3
 */
public class P2_01BagProblem_v1 {
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
    static int n, m;
    static int N = 1010;
    static int[][] dp = new int[N][N];
    static int[] w = new int[N];
    static int[] v = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();    // 物品个数
        m = sc.nextInt();    // 背包容量

        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // 不选的情况
                dp[i][j] = dp[i - 1][j];
                // 选的情况（只有当前背包容量 >= 当前物品的体积才选）
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i <= m; i++) {
            res = Math.max(res, dp[n][i]);
        }
        System.out.println(res);

        sc.close();
    }
}
