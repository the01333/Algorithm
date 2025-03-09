package com.puxinxiaolin.subject.luogu.search;

import java.util.Scanner;

/**
 * @Description: 填涂颜色
 * @Author: YccLin
 * @Date: 2024/11/24
 */
public class P1162 {
    static int n;
    static int[][] g;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = sc.nextInt();
            }
        }

        // 标记外边界
        for (int i = 0; i < n; i++) {
            if (g[0][i] == 0) {
                mark(0, i);
            }
            if (g[i][0] == 0) {
                mark(i, 0);
            }
            if (g[n - 1][i] == 0) {
                mark(n - 1, i);
            }
            if (g[i][n - 1] == 0) {
                mark(i, n - 1);
            }
        }

        // 填充内圆
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == -1) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(g[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n || g[x][y] != 0) {
            return;
        }

        g[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i]);
        }
    }

    private static void mark(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n || g[x][y] != 0) {
            return;
        }

        g[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            mark(x + dx[i], y + dy[i]);
        }
    }
}
