package com.puxinxiaolin.subject.lanqiaoCloudCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P19775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.nextLine();
        List<long[]> list = new ArrayList<>();
        for (long i = 0; i < n; i++) {
            long x = sc.nextInt();
            long y = sc.nextInt();
            list.add(new long[]{x, y});
        }

        for (long[] l : list) {
            System.out.println(dealCombination(l[0], l[1]));
        }
    }

    private static long dealCombination(long x, long y) {
        long negativeDiv = 1, div = 1;
        for (long i = x, count = 1; count <= y; i--, count++) {
            negativeDiv *= i;
        }
        for (long j = y; j > 0; j--) {
            div *= j;
        }
        long ans = negativeDiv / div;
        return ans % 1000000007L;
    }
}
