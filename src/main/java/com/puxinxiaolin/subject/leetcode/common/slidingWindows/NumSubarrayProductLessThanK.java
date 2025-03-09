package com.puxinxiaolin.subject.leetcode.common.slidingWindows;

public class NumSubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int n = nums.length;
        int prod = 1, l = 0, ans = 0;
        for (int r = 0; r < n; r++) {
            prod *= nums[r];
            while (prod >= k) {
                prod /= nums[l++];
            }
            ans += r - l + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100) == 8);
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0) == 0);
    }
}
