package com.puxinxiaolin.subject.AINuggets.middle;

import java.util.Arrays;

public class P6 {
    public static int solution(int n, int H, int A, int[] h, int[] a) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            // 检查小E是否可以击败当前怪物
            if (H <= h[i] || A <= a[i]) {
                dp[i] = 0;
                continue;
            }

            for (int j = 0; j < i; j++) {
                if (dp[j] > 0 && h[i] > h[j] && a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 4, 5, new int[]{1, 2, 3}, new int[]{3, 2, 1}) == 1);
        System.out.println(solution(5, 10, 10, new int[]{6, 9, 12, 4, 7}, new int[]{8, 9, 10, 2, 5}) == 2);
        System.out.println(solution(4, 20, 25, new int[]{10, 15, 18, 22}, new int[]{12, 18, 20, 26}) == 3);
    }
}
