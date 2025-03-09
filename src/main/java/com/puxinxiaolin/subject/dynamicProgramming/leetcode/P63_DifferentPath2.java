package com.puxinxiaolin.subject.dynamicProgramming.leetcode;

public class P63_DifferentPath2 {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}) == 2);
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}) == 1);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        // 起点或终点有障碍直接返回 0
        if (obstacleGrid[n - 1][m - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        // 初始化第一行和第一列
        for (int i = 0; i < n && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        // 由于只能向右或向下，所以（路数）: 当前位置 = 左方 + 上方
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }
        return dp[n - 1][m - 1];
    }
}
