package com.puxinxiaolin.subject.acwing.oneSubjectEveryDay;

import java.util.Scanner;

public class P6134 {
    static int N = 1000010;
    static int n;
    static int[] a = new int[N], l = new int[N], r = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int cnt = 0;  // 左边不同数的数量
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            a[i] = x;
            if (++l[x] == 1) {
                cnt++;
            }
        }
        sc.close();

        long ans = 0;
        for (int i = n; i >= 0; i--) {
            int x = a[i];
            r[x]++;
            l[x]--;
            if (l[x] == 0) {  // 减掉之后如果没有了, 不同的数 - 1
                cnt--;
            }
            if (r[x] == 2) {  // 如果当前枚举的数出现两次, 那么就加上左边不同数的数量
                ans += cnt;
                if (l[x] > 0) {
                    ans--;
                }
            }
        }

        System.out.println(ans);
    }
}
