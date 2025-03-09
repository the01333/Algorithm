package com.puxinxiaolin.subject.AINuggets.easy;

public class P103 {
    public static int solution(int x, int y) {
        int ans = 0;
        for (int i = x; i <= y; i++) {
            int t = i;
            int k = t % 10;
            boolean flag = true;
            while (t != 0) {
                if (t % 10 != k) {
                    flag = false;
                    break;
                }
                t /= 10;
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(1, 10) == 9);
        System.out.println(solution(2, 22) == 10);
    }
}
