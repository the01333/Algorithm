package com.puxinxiaolin.subject.leetcode.easyStart;

import java.util.Arrays;

public class Transpose {
    public static int[][] transpose(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepEquals(transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}), new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}));
        System.out.println(Arrays.deepEquals(transpose(new int[][]{{1, 2, 3}, {4, 5, 6}}), new int[][]{{1, 4}, {2, 5}, {3, 6}}));
    }
}
