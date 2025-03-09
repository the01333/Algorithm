package com.puxinxiaolin.subject.luogu.search;

import java.util.Scanner;

/**
 * @Description: kkksc03考前临时抱佛脚
 * @Author: YccLin
 * @Date: 2024/11/18
 */
public class P2392 {
    /*
输入:
1 2 1 3
5
4 3
6
2 4 3

输出:
20
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        int sum = 0, ans = 0;
        int[] homework = new int[21];
        int[] dp = new int[2501];    // dp[k]: 在时间限制为 k 的情况下, 一个脑子能完成的作业的最大总时间

        for (int i = 1; i <= 4; i++) {
            a[i] = sc.nextInt();
        }

        // 遍历每个科目
        for (int i = 1; i <= 4; i++) {
            sum = 0;
            // 输入每个科目内的作业耗时, 并记录总耗时
            for (int j = 1; j <= a[i]; j++) {
                homework[j] = sc.nextInt();
                sum += homework[j];
            }

            // 作业数
            for (int j = 1; j <= a[i]; j++) {
                // 时间（因为想要最短时间, 有两个脑子并行处理, 所以最快的就是两个脑子处理的时间是相等的, 因此最大值置为 sum / 2）
                for (int k = sum / 2; k >= homework[j]; k--) {
                    dp[k] = Math.max(dp[k], dp[k - homework[j]] + homework[j]);
                }
            }

            ans += sum - dp[sum / 2];

            for (int j = 1; j <= sum / 2; j++) {
                dp[j] = 0;
            }
        }

        System.out.println(ans);
        sc.close();
    }

}
