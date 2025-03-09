package com.puxinxiaolin.subject.AINuggets.middle;

import java.util.HashSet;
import java.util.Set;

public class P162 {
    /**
     * 好数: 最多包含两种不同数字
     *
     * @param n
     * @return
     */
    public static int solution(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i <= 101) {
                ans++;
            } else {
                if (judge(i)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private static boolean judge(int n) {
        String s = String.valueOf(n);
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size() <= 2;
    }

    public static void main(String[] args) {
        System.out.println(solution(110) == 102);
        System.out.println(solution(1000) == 352);
        System.out.println(solution(1) == 1);
    }
}
