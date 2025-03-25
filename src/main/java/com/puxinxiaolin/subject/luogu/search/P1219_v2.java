package com.puxinxiaolin.subject.luogu.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description: 八皇后 Checker Challenge（二维数组）
 * @Author: YccLin
 * @Date: 2024/11/30
 */
public class P1219_v2 {
    static int n, N = 15;
    static boolean[][] g = new boolean[N][N];
    static boolean[] col = new boolean[N],
            dg = new boolean[2 * N],
            udg = new boolean[2 * N];
    static List<int[]> ans = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();

        dfs(0);

        for (int i = 0; i < Math.min(count, 3); i++) {
            for (int j = 0; j < ans.get(i).length; j++) {
                System.out.print(ans.get(i)[j] + " ");
            }
            System.out.println();
        }
        System.out.println(count);
    }

    private static void dfs(int u) {
        if (u == n) {
            int[] t = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (g[i][j]) {
                        t[i] = j + 1;
                        break;
                    }
                }
            }
            ans.add(t);
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[u + i] && !udg[n - u + i]) {
                g[u][i] = true;
                col[i] = dg[u + i] = udg[n - u + i] = true;

                dfs(u + 1);

                g[u][i] = false;
                col[i] = dg[u + i] = udg[n - u + i] = false;
            }
        }
    }
}
