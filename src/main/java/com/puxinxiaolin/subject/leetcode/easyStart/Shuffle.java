package com.puxinxiaolin.subject.leetcode.easyStart;

import java.util.Arrays;

public class Shuffle {
    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3), new int[]{2, 3, 5, 4, 1, 7}));
        System.out.println(Arrays.equals(shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4), new int[]{1, 4, 2, 3, 3, 2, 4, 1}));
        System.out.println(Arrays.equals(shuffle(new int[]{1, 1, 2, 2}, 2), new int[]{1, 2, 1, 2}));
    }
}
