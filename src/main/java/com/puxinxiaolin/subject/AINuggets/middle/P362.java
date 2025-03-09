package com.puxinxiaolin.subject.AINuggets.middle;

public class P362 {
    public static int solution(int x, int y) {
        int ans = 0;
        // 奇数 + 1    偶数 / 2
        while (y > x) {
            if (y % 2 == 0) {
                y /= 2;
            } else {
                y += 1;
            }
            ans++;
        }

        ans += x - y;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 3) == 2 ? 1 : 0);
        System.out.println(solution(4, 7) == 2 ? 1 : 0);
        System.out.println(solution(3, 66) == 9 ? 1 : 0);
    }
}
