package com.puxinxiaolin.subject.lanqiao.NO11;

public class P2 {
    public static void main(String[] args) {
        int ans = 0;
        for (long i = 2022; i < 2022222022; i++) {
            if (isMountainNumber(i)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean isMountainNumber(long n) {
        String s = String.valueOf(n);
        int len = s.length();

        // 是否是回文数
        if (!isPalindrome(s)) {
            return false;
        }

        int peakIndex = len / 2;
        for (int i = 0; i < peakIndex; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                return false;
            }
        }
        for (int i = peakIndex; i < len - 1; i++) {
            if (s.charAt(i) < s.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
