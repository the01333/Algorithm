package com.puxinxiaolin.subject.codingRandomRecording;

import java.util.Scanner;

public class ZeroOneBag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 物品数量
        int m = sc.nextInt();  // 容量
        // 把输入进行填充
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        // 初始化第一个物品在不同容量下的最大价值
        int[][] dp = new int[n][m + 1];
        for (int i = weight[0]; i <= m; i++) {
            dp[0][i] = value[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[n - 1][m]);
    }
}
