package com.puxinxiaolin.subject.luogu.greedy;

import java.util.Scanner;

public class P5019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        int ans = a[0];
        for (int i = 1; i < n; i++) {
            // 如果当前区域的下陷深度 > 上一个区域的下陷深度, 需要额外的操作次数（上一个区域的下陷深度 - 当前区域的下陷深度）
            if (a[i] > a[i - 1]) {
                ans += a[i] - a[i - 1];
            }
        }

        System.out.println(ans);
    }
}
