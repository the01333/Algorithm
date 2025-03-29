package com.puxinxiaolin.subject.leetcode.hot100.doublePointer;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int t = nums[i];
                nums[i] = nums[index];
                nums[index++] = t;
            }
        }
    }
}
