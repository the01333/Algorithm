package com.puxinxiaolin.subject.acwing.dfs;

import java.util.Scanner;

public class P842排列数字 {
    static int N = 10;
    static int n;
    static int[] path = new int[N];
    static boolean[] status = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
        sc.close();
    }

    private static void dfs(int x) {
        if (x == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            if (!status[i]) {
                path[x] = i;
                status[i] = true;
                dfs(x + 1);
                path[x] = 0;
                status[i] = false;
            }
        }
    }
}
