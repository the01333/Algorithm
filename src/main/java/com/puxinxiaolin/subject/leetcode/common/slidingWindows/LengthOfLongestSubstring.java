package com.puxinxiaolin.subject.leetcode.common.slidingWindows;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String S) {
        char[] charArray = S.toCharArray();
        int[] count = new int[128];
        int ans = 0, l = 0;
        int n = S.length();
        for (int r = 0; r < n; r++) {
            char c = charArray[r];
            count[c]++;
            while (count[c] > 1) {
                count[charArray[l++]]--;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(lengthOfLongestSubstring("pwwkew") == 3);
    }
}
