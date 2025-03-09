package com.puxinxiaolin.subject.AINuggets.easy;

import java.util.HashMap;
import java.util.Map;

public class P431 {
    public static int solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('0', 1);
        map.put('6', 1);
        map.put('9', 1);
        map.put('8', 2);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                ans += map.get(s.charAt(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution("1234567890") == 5);
        System.out.println(solution("8690") == 5);
        System.out.println(solution("1111") == 0);
    }
}
