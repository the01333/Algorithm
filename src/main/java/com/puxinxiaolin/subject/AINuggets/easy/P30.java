package com.puxinxiaolin.subject.AINuggets.easy;

import java.util.HashMap;
import java.util.Map;

public class P30 {
    public static void main(String[] args) {
        System.out.println(solution("AUBTMKAxfuu") == 1);
        System.out.println(solution("KKuuUuUuKKKKkkkkKK") == 6);
        System.out.println(solution("abcdefgh") == 0);
    }

    public static int solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        String ns = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (ns.charAt(i) == 'k' || ns.charAt(i) == 'u') {
                map.put(ns.charAt(i), map.getOrDefault(ns.charAt(i), 0) + 1);
            }
        }

        Integer k = map.getOrDefault('k', 0);
        Integer u = map.getOrDefault('u', 0);
        return k >= u ? (k > u ? u : k) : k;
    }
}
