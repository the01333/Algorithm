package com.puxinxiaolin.subject.AINuggets.easy;

import java.util.Arrays;

public class P267 {
    public static long solution(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans += Math.abs(a[i] - b[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, new int[]{5, 2, 4, 2}) == 5);
        System.out.println(solution(new int[]{1, 4, 6}, new int[]{2, 5, 7}) == 3);
        System.out.println(solution(new int[]{1, 9, 6}, new int[]{2, 5, 7}) == 4);
    }
}
