package com.puxinxiaolin.subject.AINuggets.middle;

import java.util.LinkedList;

public class P427 {
    public static int solution(String s) {
        int ans = 0;
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是 '(' ，等待后一个如果能匹配上 ans++
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    ans++;
                } else {
                    stack.pop();
                }
            }
        }

        ans += stack.size();
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution("(((") == 3);
        System.out.println(solution("()") == 0);
        System.out.println(solution("()))((") == 4);
    }
}
