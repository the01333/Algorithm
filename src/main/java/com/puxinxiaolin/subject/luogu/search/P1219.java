package com.puxinxiaolin.subject.luogu.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description: 八皇后 Checker Challenge：
 * 1. 创建一个二维数组，记录位置是否可达
 * 2. 分别创建三个数组，分别记录列、主对角线、副对角线是否可达，然后根据题目需求，创建一个存储总解法数和存储所有满足规范答案的集合
 * 3. 开始搜索，当行数等于n时，说明已经到达最后一行，直接遍历二维数组，找出Q的位置，并在遍历前创建一个存放规范答案的数组，每在一层找到Q后，
 * 将Q的位置加入数组，最后将数组加入集合，并把总解法数 + 1；而如果行数小于n，则进行递归搜索。在递归搜索时，只有当列、主对角线、反对角线没有被使用时，
 * 才将列、主对角线、副对角线设为不可达，并继续递归下一行；当最后一层递归结束后，要恢复现场，把列、主对角线、副对角线标记为未使用，并返回上一层递归
 * @Author: YccLin
 * @Date: 2024/11/30
 */
public class P1219 {
    static int n;
    static int N = 15;
    static int[] g = new int[N];
    static boolean[] col = new boolean[N];
    static boolean[] dg = new boolean[N];
    static boolean[] udg = new boolean[N];
    static List<int[]> ans = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();
        dfs(0);

        for (int i = 0; i < Math.min(cnt, 3); i++) {
            for (int j = 0; j < ans.get(i).length; j++) {
                System.out.print(ans.get(i)[j] + " ");
            }
            System.out.println();
        }
        System.out.println(cnt);
    }

    private static void dfs(int u) {
        if (u == n) {
            int[] t = new int[n];
            for (int i = 0; i < n; i++) {
                t[i] = g[i] + 1;
            }
            ans.add(t);
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[u + i] && !udg[n + u - i]) {
                g[u] = i;
                col[i] = dg[u + i] = udg[n + u - i] = true;

                dfs(u + 1);

                col[i] = dg[u + i] = udg[n + u - i] = false;
            }
        }
    }

}
