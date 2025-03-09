package com.puxinxiaolin.subject.leetcode.common.binaryTree;

import java.util.*;

public class LevelOrder {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> vals = new ArrayList<>(n);
            while (n-- > 0) {
                TreeNode poll = q.poll();
                vals.add(poll.val);
                if (poll.left != null) {
                    q.add(poll.left);
                }
                if (poll.right != null) {
                    q.add(poll.right);
                }
            }
            ans.add(vals);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(9), 3, new TreeNode(
                new TreeNode(15), 20, new TreeNode(7))
        );
        List<List<Integer>> ans = List.of(List.of(3), List.of(9, 20), List.of(15, 7));
        System.out.println(Objects.equals(levelOrder(root), ans));

        root = new TreeNode(1);
        ans = List.of(List.of(1));
        System.out.println(Objects.equals(levelOrder(root), ans));

        root = null;
        ans = List.of();
        System.out.println(Objects.equals(levelOrder(root), ans));
    }
}
