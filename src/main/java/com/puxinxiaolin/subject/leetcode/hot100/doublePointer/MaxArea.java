package com.puxinxiaolin.subject.leetcode.hot100.doublePointer;

public class MaxArea {
    public int maxArea(int[] height) {
        int ans = 0;
        int n = height.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            ans = Math.max(ans, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea.maxArea(height));
    }
}
