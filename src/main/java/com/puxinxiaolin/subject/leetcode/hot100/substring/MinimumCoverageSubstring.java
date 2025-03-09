package com.puxinxiaolin.subject.leetcode.hot100.substring;

import java.util.HashMap;
import java.util.Map;

public class MinimumCoverageSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // 记录 t 中每个字符的数量，初始值为负数，表示还需要多少个这样的字符来形成一个有效的窗口
        Map<Character, Integer> count = new HashMap<>();
        for (char c : t.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) - 1);
        }

        // 满足条件的字符数量，最小覆盖子串的起始位置，最小覆盖子串的长度
        int formed = 0, start = 0, length = Integer.MAX_VALUE;
        for (int l = 0, r = 0, required = t.length(); r < s.length(); r++) {
            char c = s.charAt(r);
            if (count.containsKey(c)) {
                if (count.get(c) < 0) {  // 仅在小于0时增加，意味着我们找到了之前缺少的字符
                    formed++;
                }
                count.put(c, count.get(c) + 1);
            }

            // 满足后尝试移动左指针l来缩小窗口
            while (formed == required) {
                if (r - l + 1 < length) {
                    start = l;
                    length = r - l + 1;
                }

                char d = s.charAt(l);
                l++;

                if (count.containsKey(d)) {
                    count.put(d, count.get(d) - 1);
                    if (count.get(d) < 0) {
                        formed--;
                    }
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}
