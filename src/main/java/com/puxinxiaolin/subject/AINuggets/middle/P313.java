package com.puxinxiaolin.subject.AINuggets.middle;

public class P313 {
    public static int solution(int n, int[] weights, int[] values, int m) {
        // 容量需要考虑 0 的情况，所以需要 + 1
        int[][] dp = new int[n][m + 1];

        // 只需要初始化选第一个物品的各个容量情况（也就是列出表格的第一行）
        for (int j = weights[0]; j <= m; j++) {
            dp[0][j] = values[0];
        }

        for (int i = 1; i < n; i++) {    // 物品
            for (int j = 0; j <= m; j++) {   // 容量
                if (j >= weights[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][m];
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{2, 1, 3}, new int[]{4, 2, 3}, 3) == 6);
        System.out.println(solution(4, new int[]{1, 2, 3, 2}, new int[]{10, 20, 30, 40}, 5) == 70);
        System.out.println(solution(2, new int[]{1, 4}, new int[]{5, 10}, 4) == 10);
    }
}
