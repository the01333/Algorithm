package com.puxinxiaolin.subject.acwing.oneSubjectEveryDay;

import java.util.Scanner;

public class P5437 {
    static int N = 200010;
    static int n, m;
    static long[] a = new long[N], b = new long[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextLong();
        }
        for (int i = 1; i <= m; i++) {
            b[i] = sc.nextLong();
        }
        sc.close();

        for (int i = 1; i <= m; i++) {
            long t = 0;  // 当前糖果吃掉的高度
            for (int j = 1; j <= n; j++) {
                if (a[j] <= t) {
                    continue;
                }
                int eat = (int) (Math.min(a[j], b[i]) - t);
                a[j] += eat;
                t += eat;
                if (t >= b[i]) {
                    break;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(a[i]);
        }
    }
}
