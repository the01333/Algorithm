package com.puxinxiaolin.subject.AINuggets.hard;

public class P33 {
    public static int solution(int n, int[] a, int[] b) {
        final int MOD = 1000000007;
        /*
            dp[i][j]: 前 i 个数字中，数字之和对 MOD 求模是 j 的方案数
            i: 前 i 张卡牌
            j: 当前选择的数字之和对 3 求模的结果（ 0、1、2）
         */
        int[][] dp = new int[n + 1][3];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 1; i <= n; i++) {
            int aMod = a[i - 1] % 3;
            int bMod = b[i - 1] % 3;

            for (int j = 0; j < 3; j++) {
                dp[i][(j + aMod) % 3] = (dp[i][(j + aMod) % 3] + dp[i - 1][j]) % MOD;
                dp[i][(j + bMod) % 3] = (dp[i][(j + bMod) % 3] + dp[i - 1][j]) % MOD;
            }
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{1, 2, 3}, new int[]{2, 3, 2}) == 3);
        System.out.println(solution(4, new int[]{3, 1, 2, 4}, new int[]{1, 2, 3, 1}) == 6);
        System.out.println(solution(5, new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}) == 32);
    }
}
