package com.puxinxiaolin.subject.AINuggets.easy;

public class P169 {
    public static boolean solution(int n, int[] a, int x, int y) {
        int indexX = -1;
        int indexY = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                indexX = i;
            }
            if (a[i] == y) {
                indexY = i;
            }
            if (indexY != -1 && indexX != -1) {
                break;
            }
        }

        return Math.abs(indexX - indexY) == 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{1, 4, 2, 3}, 2, 4));
        System.out.println(!solution(5, new int[]{3, 4, 5, 1, 2}, 3, 2));
        System.out.println(solution(6, new int[]{6, 1, 5, 2, 4, 3}, 5, 2));
    }
}
