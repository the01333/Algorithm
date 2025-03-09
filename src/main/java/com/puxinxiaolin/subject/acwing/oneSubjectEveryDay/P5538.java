package com.puxinxiaolin.subject.acwing.oneSubjectEveryDay;

import java.util.Scanner;

public class P5538 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            String s = sc.nextLine();
            if (s.charAt(s.length() - 1) == '0') {
                System.out.println("E");
            } else {
                System.out.println("B");
            }
        }
        sc.close();
    }
}
