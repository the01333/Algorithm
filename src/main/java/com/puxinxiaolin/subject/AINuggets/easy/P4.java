package com.puxinxiaolin.subject.AINuggets.easy;

import java.util.ArrayList;
import java.util.List;

public class P4 {
    public static int solution(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        // 将整数 -> 数字组
        List<List<Integer>> numberGroups = new ArrayList<>();
        for (int number : numbers) {
            List<Integer> digits = new ArrayList<>();
            while (number > 0) {
                digits.add(0, number % 10);
                number /= 10;
            }
            numberGroups.add(digits);
        }

        // 计算每组中数字的数量
        int[] groupSizes = new int[numberGroups.size()];
        for (int i = 0; i < numberGroups.size(); i++) {
            groupSizes[i] = numberGroups.get(i).size();
        }

        // 用于跟踪每组中选择的数字
        int[] indices = new int[numberGroups.size()];
        int ans = 0;

        while (true) {
            int currentSum = 0;
            for (int i = 0; i < numberGroups.size(); i++) {
                currentSum += numberGroups.get(i).get(indices[i]);
            }

            if (currentSum % 2 == 0) {
                ans++;
            }

            int next = 0;
            while (next < numberGroups.size()) {
                indices[next]++;
                if (indices[next] < groupSizes[next]) {
                    break;
                }
                indices[next] = 0;
                next++;
            }

            if (next == numberGroups.size()) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{123, 456, 789}) == 14);
        System.out.println(solution(new int[]{123456789}) == 4);
        System.out.println(solution(new int[]{14329, 7568}) == 10);
    }
}
