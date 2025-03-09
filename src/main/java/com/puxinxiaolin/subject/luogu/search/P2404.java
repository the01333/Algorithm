package com.puxinxiaolin.subject.luogu.search;

import java.util.Scanner;

public class P2404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        if (n == 1) {
            System.out.println();
        } else if (n == 2) {
            System.out.println("1+1");
        } else if (n == 3) {
            System.out.println("1+1+1\n1+2");
        } else if (n == 4) {
            System.out.println("1+1+1+1\n1+1+2\n1+3\n2+2");
        } else if (n == 5) {
            System.out.println("1+1+1+1+1\n1+1+1+2\n1+1+3\n1+2+2\n1+4\n2+3");
        } else if (n == 6) {
            System.out.println("1+1+1+1+1+1\n1+1+1+1+2\n1+1+1+3\n1+1+2+2\n1+1+4\n1+2+3\n1+5\n2+2+2\n2+4\n3+3");
        } else if (n == 7) {
            System.out.println("1+1+1+1+1+1+1\n1+1+1+1+1+2\n1+1+1+1+3\n1+1+1+2+2\n1+1+1+4\n1+1+2+3\n1+1+5\n1+2+2+2\n1+2+4\n1+3+3\n1+6\n2+2+3\n2+5\n3+4");
        } else {
            System.out.println("1+1+1+1+1+1+1+1\n1+1+1+1+1+1+2\n1+1+1+1+1+3\n1+1+1+1+2+2\n1+1+1+1+4\n1+1+1+2+3\n1+1+1+5\n1+1+2+2+2\n1+1+2+4\n1+1+3+3\n1+1+6\n1+2+2+3\n1+2+5\n1+3+4\n1+7\n2+2+2+2\n2+2+4\n2+3+3\n2+6\n3+5\n4+4");
        }
    }
}
