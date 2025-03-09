package com.puxinxiaolin.subject.leetcode.hot100.normalArray;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
        System.out.println(Arrays.toString(productExceptSelfByOptimization(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelfByOptimization(new int[]{-1, 1, 0, -3, 3})));
    }

    /**
     * 普通 O(n)
     * @param nums
     * @return
     */
    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        R[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = L[i] * R[i];
        }

        return ans;
    }

    /**
     * 优化 O(1)
     * @param nums
     * @return
     */
    public static int[] productExceptSelfByOptimization(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        int beforeSum = 1, afterSum = 1;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            ans[i] *= beforeSum;
            ans[j] *= afterSum;
            beforeSum *= nums[i];
            afterSum *= nums[j];
        }

        return ans;
    }
}
