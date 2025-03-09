package com.puxinxiaolin.subject.luogu.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class P4447 {
    /*
输入:
7
4 5 2 3 -4 -3 -5

输出:
3
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 队员数量
        long[] a = new long[n];  // 队员实力
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        sc.close();

        Arrays.sort(a);

        long ans = Integer.MAX_VALUE;
        int i = 0, j = 1, k = 0;
        while (j < n) {
            if (a[j] - a[k] != 1) {
                ans = Math.min(ans, j - i);
                i = j;
            }
            k = j;
            j++;
        }

        ans = Math.min(ans, j - i);
        System.out.println(ans);
    }
}
