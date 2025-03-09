package com.puxinxiaolin.subject.leetcode.hot100.normalArray;

/**
 * @description: 使用置换方法，比如 i 索引位有一个 x (nums[i] = x)，假设它不是位于正确位置，正确位置应该是: nums[nums[i] - 1] = x
 * @author: YCcLin
 * @date: 2025/1/6
 **/
public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    /*  3   4  -1  1
       -1   4   3  1
       -1   1   3  4
        1  -1   3  4
    */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // 这个数只有满足：是正整数、在有效范围内、不处于正确位置（ (nums[i] = x) != (nums[nums[i] - 1]) ）
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
