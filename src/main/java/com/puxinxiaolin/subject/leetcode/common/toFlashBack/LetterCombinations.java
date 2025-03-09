package com.puxinxiaolin.subject.leetcode.common.toFlashBack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinations {
    private static final String[] rules = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private final List<String> ans = new ArrayList<>();
    private char[] path;
    private char[] digits;

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return List.of();
        }

        this.digits = digits.toCharArray();
        path = new char[n];
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == digits.length) {
            ans.add(new String(path));
            return;
        }

        for (char c : rules[digits[i] - '0'].toCharArray()) {
            path[i] = c;
            dfs(i + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23").equals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")));
        System.out.println(new LetterCombinations().letterCombinations("").equals(List.of()));
        System.out.println(new LetterCombinations().letterCombinations("2").equals(Arrays.asList("a", "b", "c")));
    }
}
