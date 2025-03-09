package com.puxinxiaolin.subject.leetcode.common.binaryTree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RightSideViewTest {

    private RightSideView rightSideView;

    @Before
    public void setUp() {
        rightSideView = new RightSideView();
    }

    @Test
    public void rightSideView_EmptyTree_ReturnsEmptyList() {
        TreeNode root = null;
        List<Integer> result = rightSideView.rightSideView(root);
        assertEquals(new ArrayList<>(), result);
    }

    @Test
    public void rightSideView_SingleNodeTree_ReturnsSingleNode() {
        TreeNode root = new TreeNode(1);
        List<Integer> result = rightSideView.rightSideView(root);
        assertEquals(new ArrayList<>(Arrays.asList(1)), result);
    }

    @Test
    public void rightSideView_PerfectBinaryTree_ReturnsCorrectView() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        List<Integer> result = rightSideView.rightSideView(root);
        assertEquals(new ArrayList<>(Arrays.asList(1, 3, 4)), result);
    }

    @Test
    public void rightSideView_NonPerfectBinaryTree_ReturnsCorrectView() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        List<Integer> result = rightSideView.rightSideView(root);
        assertEquals(new ArrayList<>(Arrays.asList(1, 3, 7)), result);
    }

    @Test
    public void rightSideView_OnlyLeftChildren_ReturnsCorrectView() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        List<Integer> result = rightSideView.rightSideView(root);
        assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3)), result);
    }

    @Test
    public void rightSideView_OnlyRightChildren_ReturnsCorrectView() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        List<Integer> result = rightSideView.rightSideView(root);
        assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3)), result);
    }
}