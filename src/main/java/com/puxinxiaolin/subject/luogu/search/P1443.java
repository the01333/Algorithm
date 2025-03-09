package com.puxinxiaolin.subject.luogu.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Description: bfs解答马的距离问题：
 * 1. 创建一个二维数组，用于存储到达每个位置所需的步数，初始化为-1，表示不可达
 * 2. 设置起始位置的步数为0，并将起始位置加入队列
 * 3. 循环，直到队列为空
 * 4. 循环内首先获取队首元素并将其从队列中删除，然后把四个方向的相邻位置加入队列，并判断是否已经访问过，如果未访问过则将其步数设为当前位置步数加 1
 * 5. 循环结束后，遍历二维数组即可
 * @Author: YccLin
 * @Date: 2024/11/18
 */
public class P1443 {
    static int n, m;
    static int[][] g;

    /*
输入:
3 3 1 1

输出:
0    3    2
3    -1   1
2    1    4
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        g = new int[n][m];
        sc.close();

        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], -1);
        }
        g[x - 1][y - 1] = 0;

        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1}, dy = {2, 1, -1, -2, -2, -1, 1, 2};
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{x - 1, y - 1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
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
                System.out.print(g[i][j] + "    ");
            }
            System.out.println();
        }
    }
}
