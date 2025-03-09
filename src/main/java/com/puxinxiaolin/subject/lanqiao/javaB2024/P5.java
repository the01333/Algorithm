package com.puxinxiaolin.subject.lanqiao.javaB2024;

import java.util.Scanner;

public class P5 {
    private static final int[][][][] pl = {
            {       // 对于L
                    {{0, 0}, {1, 0}, {2, 0}, {2, 1}}, // 0
                    {{0, 0}, {0, 1}, {0, 2}, {1, 0}}, // 正向90
                    {{0, 0}, {0, 1}, {1, 1}, {2, 1}}, // 180
                    {{0, 2}, {1, 0}, {1, 1}, {1, 2}}  // 反向90
            },
            {       // 对于I
                    {{0, 0}, {1, 0}, {2, 0}, {3, 0}}, // 0
                    {{0, 0}, {0, 1}, {0, 2}, {0, 3}}  // 180
            },
            {       // 对于T
                    {{0, 0}, {0, 1}, {0, 2}, {1, 1}}, // 0
                    {{0, 0}, {1, 0}, {2, 0}, {1, -1}}, // 正向90
                    {{0, 1}, {1, 0}, {1, 1}, {1, 2}}, // 180
                    {{0, 0}, {1, 0}, {2, 0}, {1, 1}}  // 反向90
            },
            {       // 对于S
                    {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}}, // 0
                    {{0, 0}, {1, 0}, {1, 1}, {2, 1}}  // 90
            }
    };
    static int[][] g = new int[55][55];
    static int n;
    static boolean success = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    g[i][j] = sc.nextInt();
                }
            }
            System.out.println(solve() ? "Yes" : "No");
        }

        sc.close();
    }

    private static boolean solve() {
        success = false;
        choosePlan(0);
        return success;
    }

    private static void choosePlan(int now) {
        if (success) {
            return;
        }
        if (now == 4) {
            success = true;
        } else {
            for (int i = 0; i < pl[now].length; i++) {
                if (success) {
                    return;
                }

                for (int x = 1; x <= n; x++) {
                    for (int y = 1; y <= n; y++) {
                        if (!canPlace(now, i, x, y)) {
                            continue;
                        }
                        draw(now, i, x, y, 2);
                        choosePlan(now + 1);
                        draw(now, i, x, y, 1);
                    }
                }
            }
        }
    }

    private static void draw(int type, int chosen, int x, int y, int target) {
        for (int[] pos : pl[type][chosen]) {
            g[x + pos[0]][y + pos[1]] = target;
        }
    }

    private static boolean canPlace(int type, int chosen, int x, int y) {
        for (int[] pos : pl[type][chosen]) {
            int newX = x + pos[0], newY = y + pos[1];
            if (x < 1 || x > n || y < 1 || y > n || g[newX][newY] != 1) {
                return false;
            }
        }
        return true;
    }
}
