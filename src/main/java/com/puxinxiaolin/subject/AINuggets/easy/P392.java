package com.puxinxiaolin.subject.AINuggets.easy;

import java.util.Arrays;

public class P392 {
    public static int[][] solution(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] % 2 == 0) {
                    a[i][j] *= 3;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepEquals(solution(new int[][]{{1, 2, 3}, {4, 5, 6}}), new int[][]{{1, 6, 3}, {12, 5, 18}}));
        System.out.println(Arrays.deepEquals(solution(new int[][]{{7, 8, 9}, {10, 11, 12}}), new int[][]{{7, 24, 9}, {30, 11, 36}}));
        System.out.println(Arrays.deepEquals(solution(new int[][]{{2, 4}, {6, 8}}), new int[][]{{6, 12}, {18, 24}}));
    }
}
