package com.puxinxiaolin.subject.acwing.dfs;

import java.util.Scanner;

public class P843n皇后问题2 {
    static int n;
    static int N = 20;
    static char[][] g = new char[N][N];
    static boolean[] dg = new boolean[N];
    static boolean[] udg = new boolean[N];
    static boolean[] col = new boolean[N];
    static boolean[] row = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        }

        dfs(0, 0, 0);

        sc.close();
    }

    private static void dfs(int x, int y, int s) {
        if (y == n) {
            y = 0;
            x++;
        }
        if (x == n) {
            if (s == n) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(g[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            return;
        }

        dfs(x, y + 1, s);

        if (!row[x] && !col[y] && !dg[x + y] && !udg[x - y + n]) {
            g[x][y] = 'Q';
            row[x] = col[y] = dg[x + y] = udg[x - y + n] = true;
            dfs(x, y + 1, s + 1);
            row[x] = col[y] = dg[x + y] = udg[x - y + n] = false;
            g[x][y] = '.';
        }
    }
}
