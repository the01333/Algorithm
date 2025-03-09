package com.puxinxiaolin.subject.leetcode.easyStart;

public class PeakIndexInMountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int l = 1, r = arr.length - 2, ans = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] > arr[m + 1]) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0, 1, 0}) == 1);
        System.out.println(peakIndexInMountainArray(new int[]{0, 2, 1, 0}) == 1);
        System.out.println(peakIndexInMountainArray(new int[]{0, 10, 5, 2}) == 1);
    }
}
