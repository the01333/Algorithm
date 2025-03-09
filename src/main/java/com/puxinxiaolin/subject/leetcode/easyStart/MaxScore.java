package com.puxinxiaolin.subject.leetcode.easyStart;

public class MaxScore {
    public static int maxScore(String s) {
        char[] cs = s.toCharArray();
        int right = 0;
        for (char c : cs) {
            right += c - '0';
        }

        int ans = 0, left = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (cs[i] == '0') {
                left++;
            } else {
                right--;
            }
            ans = Math.max(ans, left + right);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxScore("011101") == 5);
        System.out.println(maxScore("00111") == 5);
        System.out.println(maxScore("1111") == 3);
    }
}
