package com.puxinxiaolin.subject.leetcode.hot100.substring;

import java.util.LinkedList;

/**
 * @Description: leetcode 239
 * DeQueue
 * @Author: YccLin
 * @Date: 2024/10/28
 */
public class MaxSlidingWindow2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return nums;
        }

        LinkedList<Integer> deQueue = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 确保 deQueue 始终是最大在队首 -> pop() 方便（O(1)）
            while (!deQueue.isEmpty() && nums[deQueue.peekLast()] <= nums[i]) {
                deQueue.pollLast();
            }
            deQueue.addLast(i);
            if (deQueue.peek() <= i - k) {
                deQueue.poll();
            }

            if (i + 1 >= k) {
                ans[i - k + 1] = nums[deQueue.peek()];
            }
        }
        return ans;
    }
}
