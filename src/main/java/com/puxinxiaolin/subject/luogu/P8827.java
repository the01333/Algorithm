package com.puxinxiaolin.subject.luogu;

import java.util.Random;
import java.util.Scanner;

public class P8827 {
    static int[] values;
    static int[] parent;
    static int[] depth;
    static int[] powerSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 初始化每个节点的灵力值
        values = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            values[i] = sc.nextInt();
        }
        // 初始化并查集
        parent = new int[n + 1];
        depth = new int[n + 1];
        powerSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            powerSum[i] = values[i];
        }

        // 读取边（接收两个节点 -> 边）
        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges[i] = new int[]{u, v};
            // 把两个点连接起来
            union(u, v);
        }

        // 处理操作
        for (int i = 0; i < m; i++) {
            int opt = sc.nextInt();
            if (opt == 1) {
                int e = sc.nextInt();
                int u = edges[e - 1][0];
                int v = edges[e - 1][1];
                split(u, v);  // 分裂成树
            } else if (opt == 2) {
                int u = sc.nextInt();
                int val = sc.nextInt();
                update(u, val);
            } else if (opt == 3) {
                int u = sc.nextInt();
                System.out.println(queryPowerSum(u));
            }
        }
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static int queryPowerSum(int u) {
        return 1;
    }

    private static void update(int u, int val) {

    }

    private static void split(int u, int v) {

    }

    private static void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU == rootV) {
            parent[u] = u;
//            sum[]
        }
    }
}
