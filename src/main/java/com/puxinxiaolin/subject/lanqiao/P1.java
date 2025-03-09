package com.puxinxiaolin.subject.lanqiao;

public class P1 {
    public static void main(String[] args) {
        long sum = 0;
        String s = "202320232023";
        long start = 1, end = Long.parseLong(s);
        long jc = 1;
        while (start <= end) {
            jc *= start;
            jc %= 1_000_000_000;
            sum += jc;
            sum %= 1_000_000_000;
            start++;
            if (start > 40) {
                System.out.println(sum);
            }
        }
        System.out.println(sum);
    }
}
