package com.puxinxiaolin.subject.AINuggets.middle;

public class P81 {
    public static int solution(String d1, String d2) {
        int n1 = d1.length(), n2 = d2.length();

        if (n1 == n2) {
            int ans = 0;
            for (int i = 0; i < d1.length(); i++) {
                if (d1.charAt(i) != d2.charAt(i)) {
                    ans++;
                }
            }
            return ans;
        }

        int ans = 0, i = 0, j = 0;
        if (i < n1 && j < n2) {
            if (d1.charAt(i) == d2.charAt(j)) {
                i++;
                j++;
            } else {
                // 考虑插入
                if (n1 < n2) {
                    j++;
                } else {   // 考虑删除
                    i++;
                }
                ans++;
            }
        }
        ans += Math.abs(n1 - n2);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution("AGT", "AGCT") == 1);
        System.out.println(solution("", "ACGT") == 4);
        System.out.println(solution("GCTAGCAT", "ACGT") == 5);
        System.out.println(solution("ACGT", "TGC") == 3);
    }
}
