package com.puxinxiaolin.subject.chuanZhiCup;

import java.util.Scanner;

/**
 * @Description: abb
 * @Author: YccLin
 * @Date: 2024/11/26
 */
public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        System.out.println(getCount(n, s));
    }

    private static long getCount(long n, String s) {
        long ans = 0;
        long[] count = new long[26];
        long[] pairCount = new long[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            ans += pairCount[c - 'a'];    // 如果之前有出现过一次字符c，直接加入答案即可

            for (int j = 0; j < 26; j++) {
                // 对于与c不同的字符，如果之前有出现过，则加入答案
                if (j != c - 'a') {
                    pairCount[c - 'a'] += count[j];
                }
            }
            // 维护c出现的次数
            count[c - 'a']++;
        }
        return ans;
    }
}
