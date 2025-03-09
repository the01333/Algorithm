package com.puxinxiaolin.subject.AINuggets.middle;

public class P331 {
    public static boolean solution(String s, int n) {
        for (int i = 1; i <= n; i++) {
            String str = Integer.toBinaryString(i);
            if (!s.contains(str)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("0110", 3) ? 1 : 0);
        System.out.println(!solution("1001", 4) ? 1 : 0);
        System.out.println(solution("1100101", 6) ? 1 : 0);
    }
}
