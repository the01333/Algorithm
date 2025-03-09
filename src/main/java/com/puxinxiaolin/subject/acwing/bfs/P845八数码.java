package com.puxinxiaolin.subject.acwing.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * @testInput: 2 3 4 1 5 x 7 6 8
 * @target: 19
 * @author: YCcLin
 * @date: 2025/2/5
 **/
public class P845八数码 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder startBuilder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            startBuilder.append(sc.next());
        }
        String start = startBuilder.toString();

        System.out.println(bfs(start));

        sc.close();
    }

    private static int bfs(String start) {
        String end = "12345678x";

        LinkedList<String> q = new LinkedList<>();
        Map<String, Integer> d = new HashMap<>();
        q.offer(start);
        d.put(start, 0);

        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            String cur = q.poll();
            Integer distance = d.get(cur);
            if (cur.equals(end)) {
                return distance;
            }

            // 一维 -> 二维
            int xIndex = cur.indexOf("x");
            int x = xIndex / 3, y = xIndex % 3;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                    // 把 x 所在的位置和 转换为二维的新的坐标位进行交换
                    StringBuilder sb = new StringBuilder(cur);
                    sb.setCharAt(xIndex, cur.charAt(nx * 3 + ny));
                    sb.setCharAt(nx * 3 + ny, 'x');

                    if (d.get(sb.toString()) == null) {
                        d.put(sb.toString(), distance + 1);
                        q.offer(sb.toString());
                    }
                }
            }
        }

        return -1;
    }
}
