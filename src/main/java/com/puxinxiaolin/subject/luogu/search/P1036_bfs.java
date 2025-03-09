package com.puxinxiaolin.subject.luogu.search;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description: bfs
 * @author: YCcLin
 * @date: 2025/2/18
 **/
public class P1036_bfs {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});  // 和, 已选个数, 当前索引
        int count = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int sum = curr[0], selected = curr[1], index = curr[2];

            if (selected == k) {
                if (isPrime(sum)) {
                    count++;
                }
                continue;
            }

            for (int i = index; i < n; i++) {
                q.offer(new int[]{sum + a[i], selected + 1, i + 1});
            }
        }

        System.out.println(count);
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
