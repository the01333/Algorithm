package com.puxinxiaolin.subject.leetcode.hot100.toFlashBack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, Deque<Integer> path,
                            boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = Permute.permute(nums);
        System.out.println(lists);
    }
}
