package com.puxinxiaolin.subject.lanqiao.NO11;

import java.util.*;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        System.out.println(getCount(s));

        sc.close();
    }

    private static String getCount(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0) + 1);
        }

        int max = Collections.max(cnt.values());

        // 确保有序
        Set<Character> set = new TreeSet<>();
        for (Map.Entry<Character, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() == max) {
                set.add(entry.getKey());
            }
        }

        for (Character c : set) {
            sb.append(c);
        }

        return sb.toString();
    }
}
