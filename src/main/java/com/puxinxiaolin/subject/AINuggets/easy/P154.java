package com.puxinxiaolin.subject.AINuggets.easy;

import java.util.HashMap;
import java.util.Map;

public class P154 {
    public static long solution(int m, int[] w) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int price : w) {
            map.put(price, map.getOrDefault(price, 0) + 1);
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, new int[] { 2, 3, 3, 6, 6, 6, 9, 9, 23 }) == 3);
        System.out.println(solution(4, new int[] { 1, 2, 4, 4, 4 }) == 3);
        System.out.println(solution(5, new int[] { 5, 5, 5, 5, 6, 7, 8 }) == 4);
    }
}
