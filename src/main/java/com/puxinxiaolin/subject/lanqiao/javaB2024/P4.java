package com.puxinxiaolin.subject.lanqiao.javaB2024;

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int a2 = sc.nextInt();
            int a3 = sc.nextInt();
            int a4 = sc.nextInt();
            int b4 = sc.nextInt();
            int b6 = sc.nextInt();

            int count = 0;

            int useB6 = Math.min(b6, a3 / 2);
            count += useB6 * 6;
            a3 -= useB6 * 2;
            b6 -= useB6;

            int useB6A2 = Math.min(b6, a2 / 3);
            count += useB6A2 * 6;
            a2 -= useB6A2 * 3;
            b6 -= useB6A2;

            int useB4 = Math.min(b4, a4);
            count += useB4 * 4;
            a4 -= useB4;
            b4 -= useB4;

            int useB4A2 = Math.min(b4, a2 / 2);
            count += useB4A2 * 4;
            a2 -= useB4A2 * 2;
            b4 -= useB4A2;

            System.out.println(count);
        }
        sc.close();
    }
}
