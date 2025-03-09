package com.puxinxiaolin.subject.leetcode.common.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindBottomLeftValue {
    public static int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
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
            ans.add(vals);
        }

        return ans.get(ans.size() - 1).get(0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(1), 2, new TreeNode(3)
        );
        System.out.println(findBottomLeftValue(root) == 1);

        root = new TreeNode(new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(new TreeNode(7), 5, null),
                        3,
                        new TreeNode(6))
        );
        System.out.println(findBottomLeftValue(root) == 7);
    }
}
