package com.puxinxiaolin.subject.leetcode.hot100.binarySearch;

public class SearchMatrix {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        // 对每一行进行二分
        for (int i = 0; i < n; i++) {
            int left = 0, right = m - 1;
            while (left <= right) {
                // 如果当前行的最后一个 < target，直接 break
                if (matrix[i][right] < target) {
                    break;
                }
                int mid = ((right - left) >> 1) + left;
                if (target < matrix[i][mid]) {
                    right = mid - 1;
                } else if (target > matrix[i][mid]) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
