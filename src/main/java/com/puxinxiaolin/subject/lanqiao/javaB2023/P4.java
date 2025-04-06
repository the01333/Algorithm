package com.puxinxiaolin.subject.lanqiao.javaB2023;

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        int unKnownIdx = s.indexOf('?');
        int equalIdx = s.indexOf("=");

        // A op B = ?
        if (unKnownIdx > equalIdx) {
            String left = s.substring(0, equalIdx);
            char op = 0;
            int opIdx = -1;
            for (int i = 1; i < left.length(); i++) {
                char c = left.charAt(i);
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    op = c;
                    opIdx = i;
                    break;
                }
            }
            int A = Integer.parseInt(left.substring(0, opIdx));
            int B = Integer.parseInt(left.substring(opIdx + 1));
            int ans = 0;
            switch (op) {
                case '+' -> ans = A + B;
                case '-' -> ans = A - B;
                case '*' -> ans = A * B;
                case '/' -> ans = A / B;
            }
            System.out.println(ans);
        }
        // A ? B = C
        else if (unKnownIdx != 0 && unKnownIdx < equalIdx && isOperatorPosition(s, unKnownIdx)) {
            int opIdx = unKnownIdx;
            int A = Integer.parseInt(s.substring(0, opIdx));
            int B = Integer.parseInt(s.substring(opIdx + 1, equalIdx));
            int C = Integer.parseInt(s.substring(equalIdx + 1));
            if (A + B == C) {
                System.out.println("+");
            } else if (A - B == C) {
                System.out.println("-");
            } else if (A * B == C) {
                System.out.println("*");
            } else if (B != 0 && A / B == C) {
                System.out.println("/");
            }
        }
        // ? op B = C
        else if (unKnownIdx < s.indexOf('+') || unKnownIdx < s.indexOf('-') ||
                unKnownIdx < s.indexOf('*') || unKnownIdx < s.indexOf('/')) {
            char op = s.charAt(unKnownIdx + 1);
            int B = Integer.parseInt(s.substring(s.indexOf(op) + 1, equalIdx));
            int C = Integer.parseInt(s.substring(equalIdx + 1));
            int A = 0;
            switch (op) {
                case '+' -> A = C - B;
                case '-' -> A = C + B;
                case '*' -> A = C / B;
                case '/' -> A = C * B;
            }
            System.out.println(A);
        }
        // A op ? = C
        else {
            int opIdx = s.indexOf("+");
            if (opIdx == -1) {
                opIdx = s.indexOf("-");
            }
            if (opIdx == -1) {
                opIdx = s.indexOf("*");
            }
            if (opIdx == -1) {
                opIdx = s.indexOf("/");
            }

            char op = s.charAt(opIdx);
            int A = Integer.parseInt(s.substring(0, opIdx));
            int C = Integer.parseInt(s.substring(equalIdx + 1));
            int B = 0;
            switch (op) {
                case '+' -> B = C - A;
                case '-' -> B = A - C;
                case '*' -> B = C / A;
                case '/' -> B = A / C;
            }
            System.out.println(B);
        }
    }

    /**
     * 判断是否是操作符的位置
     *
     * @param s
     * @param unKnownIdx
     * @return
     */
    private static boolean isOperatorPosition(String s, int unKnownIdx) {
        // 操作符前后一定是数字
        return Character.isDigit(s.charAt(unKnownIdx - 1))
                && Character.isDigit(s.charAt(unKnownIdx + 1));
    }
}
