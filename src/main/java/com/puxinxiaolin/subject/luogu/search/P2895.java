package com.puxinxiaolin.subject.luogu.search;

import java.util.*;

public class P2895 {
    static int[][] g = new int[310][310];   // 记录格子最早被销毁的时间
    static int INF = Integer.MAX_VALUE;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < 310; i++) {
            Arrays.fill(g[i], INF);         // 一开始标记所有格子为永远不会被销毁
        }

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int t = sc.nextInt();
            markDestroyed(x, y, t);
        }
        sc.close();

        // 检查起始点是否一开始就被摧毁
        if (g[0][0] == 0) {
            System.out.println(-1);
            return;
        }

        // bfs
        System.out.println(bfs());
    }

    private static int bfs() {
        LinkedList<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[310][310];
        q.offer(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int t = curr[2];

            if (g[x][y] == INF) {
                return t;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i], nt = t + 1;
                if (nx >= 0 && nx < 310 && ny >= 0 && ny < 310
                        && !visited[nx][ny] && g[nx][ny] > nt) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, nt});
                }
            }
        }
        return -1;
    }

    private static void markDestroyed(int x, int y, int t) {
        g[x][y] = Math.min(g[x][y], t);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < 310 && ny >= 0 && ny < 310) {
                g[nx][ny] = Math.min(g[nx][ny], t);
            }
        }
    }
}
