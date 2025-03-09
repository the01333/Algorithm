package com.puxinxiaolin.subject.acwing.quickSort;

import java.util.Scanner;

public class P785_QuickSort {
    static int N = 100000;
    static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        quickSort(a, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void quickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }

        int m = a[(l + r) >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            while (a[++i] < m);
            while (a[--j] > m);
            if (i < j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        quickSort(a, l, j);
        quickSort(a, j + 1, r);
    }
}
