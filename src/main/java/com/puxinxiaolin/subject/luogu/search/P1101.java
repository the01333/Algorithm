package com.puxinxiaolin.subject.luogu.search;

import java.util.Scanner;

public class P1101 {
    static int N = 110;
    static int n;
    static char[][] g = new char[N][N], res = new char[N][N];
    static String word = "yizhong";
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                g[i][j] = s.charAt(j);
                res[i][j] = '*';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == word.charAt(0)) {
                    for (int k = 0; k < 8; k++) {
                        if (checkWord(i, j, k)) {
                            markWord(i, j, k);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] == '*') {
                    System.out.print(res[i][j]);
                } else {
                    System.out.print(g[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static void markWord(int x, int y, int direction) {
        for (int i = 0; i < word.length(); i++) {
            int nx = x + dx[direction] * i;
            int ny = y + dy[direction] * i;
            res[nx][ny] = g[nx][ny];
        }
    }

    private static boolean checkWord(int x, int y, int direction) {
        for (int i = 0; i < word.length(); i++) {
            int nx = x + dx[direction] * i;
            int ny = y + dy[direction] * i;
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || g[nx][ny] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
