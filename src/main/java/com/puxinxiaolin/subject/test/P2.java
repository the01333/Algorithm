package com.puxinxiaolin.subject.test;

import java.util.Scanner;

public class P2 {
    static int index;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        index = 0;
        int ans = parseRegex(s);
        System.out.println(ans);
        sc.close();
    }

    private static int parseRegex(String s) {
        int ans = 0;   // 最大结果
        int cur = 0;   // 当前结果

        while (index < s.length()) {
            char c = s.charAt(index++);
            if (c == 'x') {
                cur++;
            } else if (c == '(') {
                // 递归调用扩号内的内容并加到当前结果上
                cur += parseRegex(s);
            } else if (c == ')') {
                // 递归调用结束，返回上一层
                break;
            } else if (c == '|') {
                // 更新当前结果和最大结果其中较大值，重置当前结果为 0 确保可以处理下一个选项
                ans = Math.max(ans, cur);
                cur = 0;
            }
        }

        // 确保如果没有 | 或 ) ，当前结果也会被返回
        return Math.max(ans, cur);
    }
}
