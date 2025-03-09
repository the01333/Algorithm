package com.puxinxiaolin.subject.luogu;

import java.util.*;

public class P1002 {
    static int count = 0;
    static Set<String> horseControl = new HashSet<>();  // 马的控制点集合

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    // B 点的 x 坐标
        int m = sc.nextInt();    // B 点的 y 坐标
        int cx = sc.nextInt();   // 马的 x 坐标
        int cy = sc.nextInt();   // 马的 y 坐标

        int[][] moves = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1},
                {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};

        horseControl.add(cx + "," + cy);
        for (int[] move : moves) {
            int nx = cx + move[0];
            int ny = cy + move[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                horseControl.add(nx + "," + ny);
            }
        }

//        dfs(0, 0, n, m);
//        System.out.println(count);
        System.out.println(bfs(n, m));
    }

    private static void dfs(int x, int y, int n, int m) {
        // 超出边界 或 在马的范围坐标上
        if (x > n || y > m || horseControl.contains(x + "," + y)) {
            return;
        }

        if (x == n && y == m) {
            count++;
            return;
        }

        dfs(x + 1, y, n, m);
        dfs(x, y + 1, n, m);
    }

    private static int bfs(int n, int m) {
        int ans = 0;
        int[][] direction = {{1, 0}, {0, 1}};

        Queue<int[]> q = new LinkedList<>();
        // 起点入队
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            // 到达目标点
            if (x == n && y == m) {
                ans++;
                continue;
            }

            // 向下或向右扩展
            for (int[] dir : direction) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // 检查是否越界 或 在马的控制点
                if (nx <= n && ny <= m && !horseControl.contains(nx + "," + ny)) {
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return ans;
    }
}
