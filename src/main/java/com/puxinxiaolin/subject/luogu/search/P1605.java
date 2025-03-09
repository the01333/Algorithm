package com.puxinxiaolin.subject.luogu.search;

import java.util.Scanner;

public class P1605 {
    static int N = 10;
    static int n, m, cnt;
    static int[][] g = new int[N][N];
    static boolean[][] visited = new boolean[N][N];
    static int[] start = new int[2], end = new int[2];
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        cnt = sc.nextInt();

        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int endX = sc.nextInt();
        int endY = sc.nextInt();
        start[0] = startX - 1;
        start[1] = startY - 1;
        end[0] = endX - 1;
        end[1] = endY - 1;

        for (int i = 0; i < cnt; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            g[x - 1][y - 1] = -1;
        }

        dfs(start[0], start[1]);

        System.out.println(ans);
    }

    private static void dfs(int x, int y) {
        if (x == end[0] && y == end[1]) {
            ans++;
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && g[nx][ny] != -1) {
                dfs(nx, ny);
            }
        }

        visited[x][y] = false;
    }

}
