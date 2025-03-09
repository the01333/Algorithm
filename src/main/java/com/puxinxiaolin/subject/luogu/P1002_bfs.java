package com.puxinxiaolin.subject.luogu;

import java.util.*;

public class P1002_bfs {
    static int count;
    static Set<String> horseController = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int hx = sc.nextInt();
        int hy = sc.nextInt();

        int[][] horseMoves = {
                {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
                {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
        };
        horseController.add(hx + "," + hy);
        for (int[] horseMove : horseMoves) {
            int nhx = hx + horseMove[0];
            int nhy = hy + horseMove[1];
            horseController.add(nhx + "," + nhy);
        }

        System.out.println(bfs(n, m));
    }

    private static int bfs(int n, int m) {
        int ans = 0;
        int[][] direction = {{1, 0}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if (x == n && y == m) {
                ans++;
                continue;
            }

            for (int[] dir : direction) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx <= n && ny <= m && !horseController.contains(nx + "," + ny)) {
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return ans;
    }
}
