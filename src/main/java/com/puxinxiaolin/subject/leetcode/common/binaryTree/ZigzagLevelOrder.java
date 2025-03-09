package com.puxinxiaolin.subject.leetcode.common.binaryTree;

import java.util.*;

public class ZigzagLevelOrder {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        List<List<Integer>> ans = new ArrayList<>();
        boolean even = false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> vals = new ArrayList<>(n);
            if (!even) {   // 如果是奇数层
                while (n-- > 0) {
                    TreeNode poll = queue.poll();
                    vals.add(poll.val);
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
            } else {   // 如果是偶数层，从右到左
                while (n-- > 0) {
                    TreeNode poll = queue.pollLast();
                    vals.add(poll.val);
                    if (poll.right != null) {
                        queue.addFirst(poll.right);
                    }
                    if (poll.left != null) {
                        queue.addFirst(poll.left);
                    }
                }
            }
            ans.add(vals);
            even = !even;
        }
        return ans;
    }

    public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        List<List<Integer>> ans = new ArrayList<>();
        boolean even = false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> vals = new ArrayList<>(n);
            while (n-- > 0) {
                TreeNode poll = queue.poll();
                vals.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            if (!even) {
                ans.add(vals);
            } else {
                Collections.reverse(vals);
                ans.add(vals);
            }
            even = !even;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(9), 3, new TreeNode(
                new TreeNode(15), 20, new TreeNode(7))
        );
        List<List<Integer>> ans = List.of(List.of(3), List.of(20, 9), List.of(15, 7));
        System.out.println(Objects.equals(zigzagLevelOrder2(root), ans));

        root = new TreeNode(1);
        ans = List.of(List.of(1));
        System.out.println(Objects.equals(zigzagLevelOrder2(root), ans));

        root = null;
        ans = List.of();
        System.out.println(Objects.equals(zigzagLevelOrder2(root), ans));
    }
}
