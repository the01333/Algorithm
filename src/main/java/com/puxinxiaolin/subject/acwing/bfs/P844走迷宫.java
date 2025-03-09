package com.puxinxiaolin.subject.acwing.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class P844走迷宫 {
    static int n, m;
    static int N = 120;
    static int[][] g = new int[N][N];
    static int[][] d = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = sc.nextInt();
            }
        }

        System.out.println(bfs());

        sc.close();
    }

    private static int bfs() {
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        for (int i = 0; i < d.length; i++) {
            Arrays.fill(d[i], -1);
        }
        d[0][0] = 0;

        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + dx[i], y = poll[1] + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && d[x][y] == -1 && g[x][y] == 0) {
                    d[x][y] = d[poll[0]][poll[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }

        return d[n - 1][m - 1];
    }

}