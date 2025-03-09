package com.puxinxiaolin.subject.AINuggets.middle;

public class P14 {
    public static int solution(int n, int k) {
        int sum = 0;
        int end = n * k;
        int count = 0;
        sum += end;
        count++;
        for (int i = end - 1; i >= 0; i--) {
            if (count == n) {
                break;
            }
            if (i % k == 0) {
                sum += i;
                count++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 1) == 6);
        System.out.println(solution(2, 2) == 6);
        System.out.println(solution(4, 3) == 30);
    }
}
