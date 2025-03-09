package com.puxinxiaolin.subject.leetcode.hot100.substring;

/**
 * @Description: leetcode 239
 * 超时解法
 * @Author: YccLin
 * @Date: 2024/10/28
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len < k) return new int[0];

        int l = 0, r = k - 1;
        int[] ans = new int[len - k + 1];
        while (r < len) {
            int res = getMax(nums, l, r);
            ans[l++] = res;
            r++;
        }
        return ans;
    }

    private static int getMax(int[] nums, int l, int r) {
        int max = nums[l];
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
