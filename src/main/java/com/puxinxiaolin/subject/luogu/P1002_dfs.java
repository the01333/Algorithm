package com.puxinxiaolin.subject.luogu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P1002_dfs {
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

        dfs(0, 0, n, m);
        System.out.println(count);
    }

    private static void dfs(int x, int y, int n, int m) {
        if (x > n || y > m || horseController.contains(x + "," + y)) {
            return;
        }

        if (x == n && y == m) {
            count++;
            return;
        }

        dfs(x + 1, y, n, m);
        dfs(x, y + 1, n, m);
    }
}
