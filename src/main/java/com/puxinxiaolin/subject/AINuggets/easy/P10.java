package com.puxinxiaolin.subject.AINuggets.easy;

public class P10 {
    public static void main(String[] args) {
        System.out.println(solution(10, 1) == 10);
        System.out.println(solution(10, 2) == 5);
        System.out.println(solution(10, 3) == 4);
    }

    public static int solution(int a, int b) {
        return (a / b) + ((a % b) != 0 ? 1 : 0);
    }
}
