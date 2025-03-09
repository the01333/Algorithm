package com.puxinxiaolin.subject.chuanZhiCup;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: 最小差值
 * @Author: YccLin
 * @Date: 2024/11/25
 */
public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            res = Math.min(res, a[i] - a[i - 1]);
        }
        System.out.println(res);
    }
}
