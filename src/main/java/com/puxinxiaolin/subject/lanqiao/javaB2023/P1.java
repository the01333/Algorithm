package com.puxinxiaolin.subject.lanqiao.javaB2023;

public class P1 {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        int n = 2023;
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (fn(i, n) == 1) {
                ans++;
            }
        }

        long result = (long) ans * n % MOD;
        System.out.println(result);
    }

    private static int fn(int a, int b) {
//        while (b != 0) {
//            int t = b;
//            b = a % b;
//            a = t;
//        }
//        return a;

        int min = Math.min(a, b);
        int max = 1;

        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                max = i;
            }
        }
        return max;
    }
}
