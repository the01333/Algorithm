package com.puxinxiaolin.subject.AINuggets.easy;

import java.util.LinkedList;
import java.util.Queue;

public class P28 {
    public static int solution(int N, int M, char[][] data) {
        boolean[][] canReach = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (data[i][j] == 'O') {
                    canReach[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            // 处理当前位置的传送器或普通地板
            int[][] directions = getNextPosition(x, y, data);
            for (int[] next : directions) {
                if (next == null) continue; // 如果传送器将你传送到地图之外，跳过

                int nx = next[0];
                int ny = next[1];

                // 如果下一个位置在地图范围内且未被访问过，将其标记为 true 并加入队列
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !canReach[nx][ny]) {
                    canReach[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!canReach[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private static int[][] getNextPosition(int x, int y, char[][] data) {
        char c = data[x][y];
        int[][] directions = new int[4][2];
        int count = 0;
        switch (c) {
            case 'U' -> directions[count++] = x - 1 >= 0 ? new int[]{x - 1, y} : null;
            case 'D' -> directions[count++] = x + 1 < data.length ? new int[]{x + 1, y} : null;
            case 'L' -> directions[count++] = y - 1 >= 0 ? new int[]{x, y - 1} : null;
            case 'R' -> directions[count++] = y + 1 < data[0].length ? new int[]{x, y + 1} : null;
            default -> {
                // 处理普通地板，允许向四个方向移动
                if (x - 1 >= 0) directions[count++] = new int[]{x - 1, y};
                if (x + 1 < data.length) directions[count++] = new int[]{x + 1, y};
                if (y - 1 >= 0) directions[count++] = new int[]{x, y - 1};
                if (y + 1 < data[0].length) directions[count++] = new int[]{x, y + 1};
            }
        }
        return directions;
    }

    public static void main(String[] args) {
        char[][] pattern = {
                {'.', '.', '.', '.', '.'},
                {'.', 'R', 'R', 'D', '.'},
                {'.', 'U', '.', 'D', 'R'},
                {'.', 'U', 'L', 'L', '.'},
                {'.', '.', '.', '.', 'O'}
        };
        System.out.println(solution(4, 4, pattern) == 2);
    }
}
