package com.puxinxiaolin.subject.leetcode.hot100.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int total = rows * cols;
        int row = 0, col = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            // 把当前的行和列添加到结果中
            ans.add(matrix[row][col]);
            visited[row][col] = true;

            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];

            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols
                    || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
                nextRow = row + directions[directionIndex][0];
                nextCol = col + directions[directionIndex][1];
            }

            row = nextRow;
            col = nextCol;
        }

        return ans;
    }
}
