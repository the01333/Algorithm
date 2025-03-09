package com.puxinxiaolin.subject.leetcode.common.slidingWindows;

public class MinSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        int sum = 0, l = 0;
        for (int r = 0; r < n; r++) {
            sum += nums[r];

            // 1. ans 在循环外更新
//            while (sum - nums[l] >= target) {
//                sum -= nums[l++];
//            }
//            if (sum >= target) {
//                ans = Math.min(ans, r - l + 1);
//            }

            // 2. ans 在循环内更新
            while (sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
        }
        return ans <= n ? ans : 0;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}) == 2);
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}) == 1);
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}) == 0);
    }
}
