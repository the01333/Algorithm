package com.puxinxiaolin.subject.AINuggets.easy;

import java.util.Arrays;

public class P47 {
    public static int solution(int n, int l, int r, int[] a) {
        int count = 0;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= l && a[i] <= r) {
                if (a[i] % 2 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 3, 8, new int[]{1, 2, 6, 8, 7}) == 2);
        System.out.println(solution(4, 10, 20, new int[]{12, 15, 18, 9}) == 2);
        System.out.println(solution(3, 1, 10, new int[]{2, 4, 6}) == 3);
    }
}
