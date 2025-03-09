package com.puxinxiaolin.subject.luogu;

import java.util.*;

public class P1047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] g = new int[l + 1];  // 树的棵数
        List<int[]> areas = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            areas.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        for (int[] area : areas) {
            int start = area[0];
            int end = area[1];
            for (int i = start; i <= end; i++) {
                g[i] = -1;
            }
        }

        int ans = 0;
        for (int i : g) {
            if (i == 0) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
