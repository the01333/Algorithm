package com.puxinxiaolin.subject.AINuggets.compete;

import java.util.Arrays;
import java.util.Comparator;

public class P2 {
    public static int solution(int[][] giftPackages, int eventCapacity) {
        int maxPrice = 0;
        // 根据每个包裹的价值从高到低排序
        Arrays.sort(giftPackages, Comparator.comparingInt(o -> -o[1]));

        for (int i = 0; i < giftPackages.length; i++) {
            int packageCount = giftPackages[i][0];
            int packageValue = giftPackages[i][1];

            if (eventCapacity >= packageCount) {
                // 如果当前容量足够装下所有这种包裹
                maxPrice += packageCount * packageValue;
                eventCapacity -= packageCount;
            } else {
                // 如果当前容量不够装下所有这种包裹，装下剩余容量的包裹
                maxPrice += eventCapacity * packageValue;
                break;
            }
        }

        return maxPrice;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{new int[]{2, 5}, new int[]{1, 3}, new int[]{3, 2}}, 3) == 13);
        System.out.println(solution(new int[][]{new int[]{3, 9}, new int[]{2, 4}, new int[]{4, 8}}, 6) == 51);
        System.out.println(solution(new int[][]{new int[]{3, 1}, new int[]{2, 6}, new int[]{4, 5}}, 5) == 27);
        System.out.println(solution(new int[][]{new int[]{1, 7}, new int[]{3, 8}, new int[]{2, 10}}, 4) == 36);
    }
}
