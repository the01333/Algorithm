package com.puxinxiaolin.subject.luogu.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class P4995 {
    /*
输入1:
2
2 1

输出1:
5

输入2:
3
6 3 5

输出2:
49
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 石头个数
        int[] a = new int[n];   // 存储石头高度
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(a);

        // 起点是最后一个, 然后开始按最左和最右交替取值
        long ans = 0;
        int i = 0, j = n - 1;
        int start = 0;
        boolean takeRight = true;
        while (i <= j) {
            if (takeRight) {   // 取右边
                long diff = a[j] - start;
                ans += diff * diff;
                start = a[j--];
            } else {  // 取左边
                long diff = a[i] - start;
                ans += diff * diff;
                start = a[i++];
            }
            takeRight = !takeRight;
        }

        System.out.println(ans);
    }
}
