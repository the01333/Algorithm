package com.puxinxiaolin.subject.AINuggets.middle;

public class P202 {
    public static int solution(int m, int x) {
        if (m == x) {
            return x;
        } else if (x < m) {
            return x % m;
        } else {
            if (x % m == 0) {
                return m;
            } else {
                return x % m;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 3) == 1);
        System.out.println(solution(5, 17) == 2);
        System.out.println(solution(8, 2) == 2);
        System.out.println(solution(4, 4) == 4);
        System.out.println(solution(2, 12) == 2);
    }
}
