package com.puxinxiaolin.subject.acwing.oneSubjectEveryDay;

import java.util.Scanner;

public class P6118 {
    static int N = 500010;
    static int n;
    static long[] s = new long[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            n = sc.nextInt();
            long a = Long.MAX_VALUE;   // 第一个人拿的数量（求最小值）
            long l = n / 2 + 1;   // 第一个人吃的蛋糕数
            for (int i = 1; i <= n; i++) {
                int x = sc.nextInt();
                s[i] = s[i - 1] + x;
                if (i >= l) {   // 枚举的蛋糕数 >= 第一个人吃的蛋糕数
                    a = Math.min(a, s[i] - s[(int) (i - l)]);
                }
            }

            System.out.println(a + " " + (s[n] - a));
        }
        sc.close();
    }
}
