package com.puxinxiaolin.subject.AINuggets.hard;

public class P448 {
    public static int solution(int n, int x, int[] a) {
        int ans = 0;
        int i = 0, j = 0;
        while (j < a.length) {
            int res = 0;
            
            ans = Math.max(res, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 10, new int[]{5, -1, -5, -3, 2}) == 15);
        System.out.println(solution(2, -3, new int[]{-5, -2}) == -2);
        System.out.println(solution(6, 10, new int[]{4, -2, -11, -1, 4, -1}) == 15);
    }
}
