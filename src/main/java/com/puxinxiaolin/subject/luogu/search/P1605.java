package com.puxinxiaolin.subject.luogu.search;

import java.util.Scanner;

public class P1605 {
    static int n, m, t;
    static int N = 5;
    static int[][] g = new int[N][N];
    static boolean[][] visited = new boolean[N][N];
    static int ans = 0;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static int sx, sy, ex, ey;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        sx = sc.nextInt();
        sy = sc.nextInt();
        ex = sc.nextInt();
        ey = sc.nextInt();
        g[sx - 1][sy - 1] = 1;  // 起点
        g[ex - 1][ey - 1] = 2;  // 终点
        for (int i = 0; i < t; i++) {
            int obstacleX = sc.nextInt();
            int obstacleY = sc.nextInt();
            g[obstacleX - 1][obstacleY - 1] = -1;
        }
        sc.close();

        dfs(sx - 1, sy - 1);

        System.out.println(ans);
    }

    private static void dfs(int x, int y) {
        if (x == ex - 1 && y == ey - 1) {
            ans++;
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m
                    && !visited[nx][ny] && g[nx][ny] != -1) {
                dfs(nx, ny);
            }
        }

        visited[x][y] = false;
    }
}
