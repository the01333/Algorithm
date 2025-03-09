package com.puxinxiaolin.subject.leetcode.hot100.matrix;

import java.util.Arrays;

public class RotateImg {
    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        int[][] matrix2 = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];
        // 翻转后: n[i][j] => n2[j][n - i - 1]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[j][n - i - 1] = matrix[i][j];
            }
        }

        System.arraycopy(newMatrix, 0, matrix, 0, n);
    }
}
