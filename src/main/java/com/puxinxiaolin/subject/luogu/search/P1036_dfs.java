package com.puxinxiaolin.subject.luogu.search;

import java.util.Scanner;

/**
 * @description: dfs
 *
 * @author: YCcLin
 * @date: 2025/2/18
 **/
public class P1036_dfs {
    static int[] a;
    static int n, k, ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        dfs(0, 0, 0);
        System.out.println(ans);
    }

    /**
     * dfs
     *
     * @param m:      已经选择的数的数量
     * @param sum:    累加的和
     * @param startI: 代表升序序列, 避免重复累加
     */
    private static void dfs(int m, int sum, int startI) {
        if (m == k) {
            if (isPrime(sum)) {
                ans++;
                return;
            }
        }

        for (int i = startI; i < n; i++) {
            dfs(m + 1, sum + a[i], i + 1);
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
