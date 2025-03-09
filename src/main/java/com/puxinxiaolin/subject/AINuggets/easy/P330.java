package com.puxinxiaolin.subject.AINuggets.easy;

public class P330 {
    public static int solution(int N) {
        String bin = Integer.toBinaryString(N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }

        // 十进制 -> 二进制
        int ans = 0;
        String res = new String(sb);
        int p = 0;
        for (int i = res.length() - 1; i >= 0; i--) {
            ans += (int) (Integer.parseInt(String.valueOf(res.charAt(i))) * Math.pow(2, p));
            p++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(5) == 2 ? 1 : 0);
        System.out.println(solution(10) == 5 ? 1 : 0);
        System.out.println(solution(0) == 1 ? 1 : 0);
    }
}
