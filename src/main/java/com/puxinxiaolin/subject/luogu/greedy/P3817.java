package com.puxinxiaolin.subject.luogu.greedy;

import java.util.Scanner;

public class P3817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int ans = 0;
        int[] a = new int[n + 1];
        a[1] = sc.nextInt();
        // 第一个数特判, 小于等于 x 即可
        if (a[1] > x) {
            ans += a[1] - x;
            a[1] = x;   // 要吃的最少, 即 a[0] = x
        }

        for (int i = 2; i <= n; i++) {
            a[i] = sc.nextInt();
            // 相邻数（cur 和 cur - 1）之和如果 > x
            int res = a[i] + a[i - 1];
            if (res > x) {
                ans += res - x;
                a[i] = x - a[i - 1];
            }
        }
        sc.close();

        System.out.println(ans);
    }
}
