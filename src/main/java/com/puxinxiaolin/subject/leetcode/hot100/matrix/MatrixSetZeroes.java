package com.puxinxiaolin.subject.leetcode.hot100.matrix;

import java.util.Arrays;

/**
 * @description: 用 row 和 col 去记录每一行每一列是否为 0；
 * 如果 matrix[i][j] == 0，则将对应的 row[i] 和 col[j] 设为 true
 * @author: YCcLin
 * @date: 2025/1/7
 **/
public class MatrixSetZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

        matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
