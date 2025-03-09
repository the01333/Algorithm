package com.puxinxiaolin.subject.AINuggets.easy;

public class P32 {
    public static int solution(int n, int A, int B, int[] array_a) {
        boolean[][][] dp = new boolean[n + 1][10][10];

        dp[0][0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    // 当前元素不加入任何一组
                    if (dp[i - 1][j][k]) {
                        dp[i][j][k] = true;
                    }
                    // 当前元素加入A组
                    if (dp[i - 1][(j - array_a[i - 1] + 10) % 10][k]) {
                        dp[i][j][k] = true;
                    }
                    // 当前元素加入B组
                    if (dp[i - 1][j][(k - array_a[i - 1] + 10) % 10]) {
                        dp[i][j][k] = true;
                    }
                }
            }
        }

        int ans = 0;
        if (dp[n][A][B]) ans++;
        if (A == B && dp[n][A][0]) {
            ans++;
        } else {
            if (dp[n][A][0]) ans++;
            if (dp[n][0][B]) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 1, 1};
        int[] array2 = {1, 1, 1};
        int[] array3 = {1, 1};

        System.out.println(solution(3, 1, 2, array1) == 3);
        System.out.println(solution(3, 3, 5, array2) == 1);
        System.out.println(solution(2, 1, 1, array3) == 2);
    }
}
