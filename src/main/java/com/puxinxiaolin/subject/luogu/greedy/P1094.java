package com.puxinxiaolin.subject.luogu.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class P1094 {
    /*
输入:
100
9
90
20
20
30
50
60
70
80
90

输出:
6
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(a);

        int ans = 0;
        int i = 0, j = n - 1;
        while (i < j) {
            if (a[i] + a[j] <= w) {
                i++;
            }
            j--;
            ans++;
        }

        if (i == j) {
            ans++;
        }

        System.out.println(ans);
    }
}
