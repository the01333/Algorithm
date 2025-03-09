package com.puxinxiaolin.subject.AINuggets.hard;

import java.util.HashSet;
import java.util.Set;

public class P209 {
    public static int solution(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            int curOr = 0;
            for (int j = i; j < a.length; j++) {
                curOr |= a[j];
                set.add(curOr);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 4}) == 6);
        System.out.println(solution(new int[]{5, 3, 8, 1}) == 8);
        System.out.println(solution(new int[]{1, 1}) == 1);
        System.out.println(solution(new int[]{7, 8, 9, 10, 11}) == 6);
    }
}
