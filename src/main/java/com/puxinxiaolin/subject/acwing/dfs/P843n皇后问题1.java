package com.puxinxiaolin.subject.acwing.dfs;

import java.util.Scanner;

public class P843n皇后问题1 {
    static int n;
    static int N = 20;
    static char[][] g = new char[N][N];
    static boolean[] dg = new boolean[N];
    static boolean[] udg = new boolean[N];
    static boolean[] col = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        }

        dfs(0);

        sc.close();
    }

    private static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(g[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[u + i] && !udg[n + u - i]) {
                g[u][i] = 'Q';
                col[i] = dg[u + i] = udg[n + u - i] = true;
                dfs(u + 1);
                col[i] = dg[u + i] = udg[n + u - i] = false;
                g[u][i] = '.';
            }
        }
    }
}
