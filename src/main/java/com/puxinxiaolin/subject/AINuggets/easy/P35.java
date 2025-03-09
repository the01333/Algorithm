package com.puxinxiaolin.subject.AINuggets.easy;

import java.util.*;

public class P35 {
    public static List<Integer> solution(List<Integer> a, List<Integer> b) {
        Set<Integer> set = new HashSet<>(a);
        List<Integer> ans = new ArrayList<>();
        for (Integer i : b) {
            if (set.contains(i)) {
                ans.add(i);
            }
        }
        ans.sort((a1, a2) -> a2 - a1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(Arrays.asList(1, 2, 3, 7), Arrays.asList(2, 5, 7)).equals(Arrays.asList(7, 2)));
        System.out.println(solution(Arrays.asList(1, 4, 8, 10), Arrays.asList(2, 4, 8, 10)).equals(Arrays.asList(10, 8, 4)));
        System.out.println(solution(Arrays.asList(3, 5, 9), Arrays.asList(1, 4, 6)).equals(Collections.emptyList()));
        System.out.println(solution(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)).equals(Arrays.asList(3, 2, 1)));
    }
}
