package com.puxinxiaolin.subject.luogu.search;

import java.util.Scanner;

/**
 * @Description: Lake Counting S
 * @Author: YccLin
 * @Date: 2024/11/24
 */
public class P1596 {
    static char[][] g;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        g = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                g[i][j] = line.charAt(j);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'W' && !visited[i][j]) {
                    dfs(i, j);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    private static void dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || g[x][y] != 'W' || visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            dfs(x + dx[i], y + dy[i]);
        }
    }
}
