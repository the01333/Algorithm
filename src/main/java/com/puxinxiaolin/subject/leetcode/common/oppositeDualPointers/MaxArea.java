package com.puxinxiaolin.subject.leetcode.common.oppositeDualPointers;

public class MaxArea {
    public static int maxArea(int[] h) {
        int l = 0, r = h.length - 1;
        int ans = 0;
        while (l < r) {
            int area = (r - l) * Math.min(h[l], h[r]);
            ans = Math.max(ans, area);
            if (h[l] < h[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}) == 49);
        System.out.println(maxArea(new int[]{1, 1}) == 1);
    }
}
