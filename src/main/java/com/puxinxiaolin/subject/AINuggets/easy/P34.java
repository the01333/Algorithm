package com.puxinxiaolin.subject.AINuggets.easy;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P34 {
    public static int solution(int n, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = set.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        if (list.size() < 3) {
            return list.get(0);
        } else {
            return list.get(2);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{3, 2, 1}) == 1);
        System.out.println(solution(2, new int[]{1, 2}) == 2);
        System.out.println(solution(4, new int[]{2, 2, 3, 1}) == 1);
    }
}
