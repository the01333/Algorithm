package com.puxinxiaolin.subject.leetcode.common.oppositeDualPointers;

public class Trap {
    public static int trap(int[] height) {
        int n = height.length;
        // 前缀最大值
        int[] preMax = new int[n];
        preMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }
        // 后缀最大值
        int[] sufMax = new int[n];
        sufMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }

        // 每个前缀和后缀的最大值中取最小值，减去当前高度，就是当前位置能存储的雨水量
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(preMax[i], sufMax[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}) == 6);
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}) == 9);
    }
}
