package com.puxinxiaolin.subject.luogu.enumeration;

import java.util.*;

public class P2089 {
    static List<int[]> ans = new ArrayList<>();
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();

        // 10 种配料
        int[] a = new int[10];
        backtrace(0, 0, a);

        ans.sort((x, y) -> {
            for (int i = 0; i < 10; i++) {
                if (x[i] != y[i]) {
                    return x[i] - y[i];
                }
            }
            return 0;
        });

        System.out.println(ans.size());
        for (int[] an : ans) {
            for (int i = 0; i < 10; i++) {
                System.out.print(an[i] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 回溯
     *
     * @param index
     * @param sum
     * @param a
     */
    private static void backtrace(int index, int sum, int[] a) {
        if (index == 10) {
            if (sum == n) {
                ans.add(Arrays.copyOf(a, 10));
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            a[index] = i;
            backtrace(index + 1, sum + i, a);
        }
    }
}
