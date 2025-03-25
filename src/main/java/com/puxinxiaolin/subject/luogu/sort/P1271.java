package com.puxinxiaolin.subject.luogu.sort;

import java.util.Scanner;

public class P1271 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            int candidate = sc.nextInt();
            a[candidate]++;
        }
        sc.close();


        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < a[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
