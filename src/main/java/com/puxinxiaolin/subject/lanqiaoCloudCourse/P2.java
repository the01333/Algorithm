package com.puxinxiaolin.subject.lanqiaoCloudCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2 {

    static int N;
    static int[] happiness;     // 每个节点的快乐指数
    static List<List<Integer>> tree;
    static int[][] dp;   // dp 数组，dp[u][0] 不选 u（子节点可以选也可以不选），dp[u][1] 选 u（子节点一定不能选）

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        happiness = new int[N + 1];
        tree = new ArrayList<>();
        dp = new int[N + 1][2];

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 编号从 1 开始
        for (int i = 1; i <= N; i++) {
            happiness[i] = sc.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree.get(b).add(a);
            tree.get(a).add(b);
        }

        // 从根节点 1 开始 DFS
        dfs(1, -1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    private static void dfs(int u, int parent) {
        dp[u][0] = 0;   // 不选 u
        dp[u][1] = happiness[u];   // 选 u

        for (Integer v : tree.get(u)) {
            if (v == parent) {
                continue;    // 跳过父节点
            }
            dfs(v, u);

            // 不选 u
            dp[u][0] += Math.max(dp[v][0], dp[v][1]);
            // 选 u
            dp[u][1] += dp[v][0];
        }
    }
}
