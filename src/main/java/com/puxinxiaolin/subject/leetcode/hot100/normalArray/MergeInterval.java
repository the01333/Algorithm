package com.puxinxiaolin.subject.leetcode.hot100.normalArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {4, 5}})));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();
        for (int[] p : intervals) {
            int m = ans.size();
            // m > 0 是为了确保第一次会先添加
            if (m > 0 && p[0] <= ans.get(m - 1)[1]) {
                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], p[1]);
            } else {
                ans.add(p);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
