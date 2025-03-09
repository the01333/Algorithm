package com.puxinxiaolin.subject.lanqiao.javaB2024;

import java.util.ArrayList;
import java.util.List;

public class P2 {
    public static void main(String[] args) {
        long maxLimit = 10_000_000L;
        System.out.println(findAns(maxLimit));
    }

    private static long findAns(long maxLimit) {
        long ans = 0;
        for (long i = 0; i <= maxLimit; i++) {
            if (isFibonacciLikeNum(i, maxLimit)) {
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }

    private static boolean isFibonacciLikeNum(long num, long maxLimit) {
        String s = String.valueOf(num);
        int n = s.length();

        List<Long> seq = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            seq.add((long) (s.charAt(i) - '0'));
        }

        while (true) {
            long nextNum = 0;
            for (int i = seq.size() - n; i < seq.size(); i++) {
                nextNum += seq.get(i);
            }

            if (nextNum > maxLimit) {
                break;
            }
            if (nextNum == num) {
                return true;
            }

            seq.add(nextNum);
        }
        return false;
    }
}
