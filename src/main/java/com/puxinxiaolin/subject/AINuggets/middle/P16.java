package com.puxinxiaolin.subject.AINuggets.middle;

public class P16 {
    public static int solution(int n, int[] array) {
        int ans = 0;
        for (int k = 1; k <= n; k++) {
            int res = 0;
            for (int i = 0; i <= n - k; i++) {
                int min = array[i];
                for (int j = i + 1; j < i + k; j++) {
                    if (array[j] < min) {
                        min = array[j];
                    }
                }
                res = Math.max(res, min * k);
            }
            ans = Math.max(ans, res);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{1, 2, 3, 4, 5}) == 9);
    }
}
