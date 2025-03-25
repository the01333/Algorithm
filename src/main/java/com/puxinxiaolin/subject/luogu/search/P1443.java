package com.puxinxiaolin.subject.luogu.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Description: bfs解答马的距离问题
 * @Author: YccLin
 * @Date: 2024/11/18
 */
public class P1443 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();

        int[][] g = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], -1);
        }
        g[x - 1][y - 1] = 0;

        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1}, dy = {2, 1, -1, -2, -2, -1, 1, 2};
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{x - 1, y - 1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i], ny = cy + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && g[nx][ny] == -1) {
                    g[nx][ny] = g[cx][cy] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(g[i][j] + " ");
            }
            System.out.println();
        }
    }
}
