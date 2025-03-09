package com.puxinxiaolin.subject.luogu;

import java.util.Scanner;

public class P1115 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(getMax(a));
    }

    private static int getMax(int[] a) {
        int ans = a[0], res = a[0];
        for (int i = 1; i < a.length; i++) {
            // 下一个数 和 两者相加 进行比较，维护较大值为 res
            res = Math.max(a[i], res + a[i]);
            ans = Math.max(ans, res);
        }
        return ans;
    }
}
