package com.puxinxiaolin.subject.luogu.greedy;

import java.util.Scanner;

public class P1106 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        sc.close();

        int i;
        while (k > 0) {
            for (i = 0; i < s.length() - 1 && s.charAt(i) <= s.charAt(i + 1); i++) {

            }
            s = s.substring(0, i) + s.substring(i + 1);
            k--;
        }

        // 前导 0 的情况
        int start = 0;
        while (start < s.length() && s.charAt(start) == '0') {
            start++;
        }
        s = s.substring(start);

        if (s.isEmpty()) {
            s = "0";
        }

        System.out.println(s);
    }
}
