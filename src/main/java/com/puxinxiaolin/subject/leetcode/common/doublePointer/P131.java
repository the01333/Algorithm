package com.puxinxiaolin.subject.leetcode.common.doublePointer;

import java.util.ArrayList;
import java.util.List;

public class P131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                path.add(s.substring(start, i + 1));
                backtrack(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P131 p131 = new P131();
        System.out.println(p131.partition("aab").equals(List.of(List.of("a", "a", "b"), List.of("aa", "b"))));
        System.out.println(p131.partition("a").equals(List.of(List.of("a"))));
    }
}
