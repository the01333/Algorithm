package com.puxinxiaolin.subject.leetcode.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 1, 1}));
        System.out.println(threeSum(new int[]{0, 0, 0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        // 枚举i，并预留位置给后面的j、k
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) {
                continue;
            }
            // 特判: 如果x和除去当前的两个最小相加大于0的话 或者 如果x和除去当前的两个最大相加小于0的话，不用往下找了
            if (x + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            if (x + nums[n - 2] + nums[n - 1] < 0) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = x + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    ans.add(List.of(x, nums[j], nums[k]));
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    k--;
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return ans;
    }
}
