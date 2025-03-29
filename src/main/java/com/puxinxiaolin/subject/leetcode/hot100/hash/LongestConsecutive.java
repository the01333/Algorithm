package com.puxinxiaolin.subject.leetcode.hot100.hash;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (Integer x : set) {
            if (set.contains(x - 1)) {
                // 发现新起点
                continue;
            }

            int y = x + 1;
            while (set.contains(y)) {
                y++;
            }
            ans = Math.max(ans, y - x);
        }

        return ans;
    }
}
