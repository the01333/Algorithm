package com.puxinxiaolin.subject.acwing;

import java.util.Scanner;

public class P842_排列数字 {
    static int n;
    static int N = 10;
    static int[] path = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
    }

    private static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            if (!st[i]) {
                path[u] = i;
                st[i] = true;
                dfs(u + 1);
                path[u] = 0;   // 回溯
                st[i] = false;
            }
        }
    }
}
