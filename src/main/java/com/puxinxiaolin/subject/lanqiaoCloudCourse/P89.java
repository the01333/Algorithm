package com.puxinxiaolin.subject.lanqiaoCloudCourse;

import java.util.*;

public class P89 {
    static int n;
    static int[][] a;
    static boolean[][] visited;
    static int[] north, west, vs;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        north = new int[n];
        west = new int[n];
        a = new int[n][n];
        vs = new int[n * n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) north[i] = sc.nextInt();
        for (int i = 0; i < n; i++) west[i] = sc.nextInt();
        sc.close();

        dfs(0, 0, 0);
    }

    private static void dfs(int startX, int startY, int step) {
        visited[startX][startY] = true;
        vs[step] = startX * n + startY;
        north[startY]--;
        west[startX]--;

        if (startX == n - 1 && startY == n - 1 && check()) {
            for (int i = 0; i <= step; i++) {
                System.out.print(vs[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = startX + dx[i], ny = startY + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                if (north[ny] > 0 && west[nx] > 0) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, step + 1);
                    visited[nx][ny] = false;
                }
            }
        }
        // 回溯
        north[startY]++;
        west[startX]++;
    }

    private static boolean check() {
        for (int i = 0; i < n; i++) {
            if (north[i] != 0 || west[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
