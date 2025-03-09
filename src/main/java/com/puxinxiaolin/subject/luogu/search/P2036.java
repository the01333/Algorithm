package com.puxinxiaolin.subject.luogu.search;

import java.util.Scanner;

public class P2036 {
    static int N = 12;
    static int[] s = new int[N];
    static int[] b = new int[N];
    static int ans = Integer.MAX_VALUE, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        sc.close();

        dfs(1, 1, 0);
        System.out.println(ans);
    }

    /**
     * ans = Math.abs(酸度乘积, 苦度总和)
     *
     * @param i: 当前第i个配料
     * @param x: 当前酸度
     * @param y: 当前苦度
     */
    private static void dfs(int i, int x, int y) {
        if (i > n) {
            if (x == 1 && y == 0) {  // 如果没有添加任何配料, 则直接返回
                return;
            }
            ans = Math.min(ans, Math.abs(x - y));
            return;
        }

        dfs(i + 1, x * s[i], y + b[i]);
        dfs(i + 1, x, y);
    }
}
