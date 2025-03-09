package com.puxinxiaolin.subject.leetcode.common.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    static List<Integer> ans;

    public List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<>();
        fn(root, 0);
        return ans;
    }

    private static void fn(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (depth == ans.size()) {
            ans.add(node.val);
        }
        fn(node.right, depth + 1);
        fn(node.left, depth + 1);
    }
}
