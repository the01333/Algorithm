package com.puxinxiaolin.subject.lanqiao.javaB2024;

public class P1 {
    public static void main(String[] args) {
        long n = 202420242024L;
        System.out.println(findNthMultiple(n));
    }

    private static long findNthMultiple(long n) {
        long low = 1;
        long high = Long.MAX_VALUE;
        long result = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long count = countMultiples(mid);

            if (count >= n) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static long countMultiples(long x) {
        long lcm20_24 = 120;
        return x / 20 + x / 24 - x / lcm20_24;
    }
}
