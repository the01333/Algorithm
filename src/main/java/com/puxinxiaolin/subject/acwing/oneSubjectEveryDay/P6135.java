package com.puxinxiaolin.subject.acwing.oneSubjectEveryDay;

import java.util.Scanner;

public class P6135 {
    static int N = 7510;
    static int n;
    static int[] a = new int[N],  // 奶牛顺序
            b = new int[N],   // 检查顺序
            ans = new int[N];  // 奶牛对应头数对应的检查种类次数

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }

        sc.close();

        int cnt = 0;
        // 初始的情况
        for (int i = 1; i <= n; i++) {
            if (a[i] == b[i]) {
                cnt++;
            }
        }
        // 反转、交换的情况
        for (int i = 1; i <= n; i++) {
            // 区间长度有奇数和偶数（奇数: i 和 i + 0   偶数: i 和 i + 1）
            for (int j = 0; j < 2; j++) {
                int sum = cnt;
                for (int l = i, r = i + j; l >= 1 && r <= n; l--, r++) {
                    if (a[l] == b[l]) sum--;
                    if (a[r] == b[r]) sum--;

                    if (a[l] == b[r]) sum++;
                    if (a[r] == b[l]) sum++;
                    ans[sum]++;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }
}
