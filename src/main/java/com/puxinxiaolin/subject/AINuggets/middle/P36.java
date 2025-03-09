package com.puxinxiaolin.subject.AINuggets.middle;

import java.util.Arrays;

public class P36 {
    public static long solution(String s, int[] a, int m, int k) {
        int n = s.length();
        int[] noMushroom = new int[n];
        int[] mushroom = new int[n];
        int noMushroomCount = 0, mushroomCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                noMushroom[noMushroomCount++] = a[i];
            } else {
                mushroom[mushroomCount++] = a[i];
            }
        }

        Arrays.sort(noMushroom, 0, noMushroomCount);
        Arrays.sort(mushroom, 0, mushroomCount);

        long minPrice = Long.MAX_VALUE;

        for (int i = 0; i <= Math.min(k, noMushroomCount); i++) {
            if (k - i <= mushroomCount && k - i <= m) {
                long currentPrice = 0;
                for (int j = 0; j < i; j++) {
                    currentPrice += noMushroom[j];
                }
                for (int j = 0; j < k - i; j++) {
                    currentPrice += mushroom[j];
                }
                minPrice = Math.min(minPrice, currentPrice);
            }
        }
        return minPrice == Long.MAX_VALUE ? -1 : minPrice;
    }

    public static void main(String[] args) {
        System.out.println(solution("001", new int[]{10, 20, 30}, 1, 2) == 30);
        System.out.println(solution("111", new int[]{10, 20, 30}, 1, 2) == -1);
        System.out.println(solution("0101", new int[]{5, 15, 10, 20}, 2, 3) == 30);
    }
}
