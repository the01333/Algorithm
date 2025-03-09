package com.puxinxiaolin.subject.AINuggets.easy;

public class P25 {
    public static int solution(String dna1, String dna2) {
        int n = dna1.length();
        int m = dna2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dna1.charAt(i - 1) == dna2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(solution("AGCTTAGC", "AGCTAGCT") == 2);
        System.out.println(solution("AGCCGAGC", "GCTAGCT") == 4);
    }
}
