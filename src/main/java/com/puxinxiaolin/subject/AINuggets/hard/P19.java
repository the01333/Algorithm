package com.puxinxiaolin.subject.AINuggets.hard;

public class P19 {
//    public static String solution(int n, int k, String s) {
//        char[] chars = s.toCharArray();
//        int l = 0;
//        while (l < n && k > 0) {
//            while (l < n && chars[l] == '0') {
//                l++;
//            }
//            if (l >= n) {
//                break;
//            }
//
//            int r = l + 1;
//            while (r < n && chars[r] == '1') {
//                r++;
//            }
//            if (r >= n) {
//                break;
//            }
//            while (r > l && k > 0) {
//                char t = chars[r];
//                chars[r] = chars[r - 1];
//                chars[r - 1] = t;
//                r--;
//                k--;
//            }
//            l++;
//        }
//        return new String(chars);
//    }

    public static String solution(int n, int k, String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            if (chars[i] == '0') {
                int swap = 0;
                // 尽可能把 0 往前移动
                for (int j = i; j > 0 && swap < k; j--) {
                    // 前一位是 1, swap
                    if (chars[j - 1] == '1') {
                        char t = chars[j];
                        chars[j] = chars[j - 1];
                        chars[j - 1] = t;
                        swap++;
                    }
                }
                // 维护剩下的交换次数
                k -= swap;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 2, "01010").equals("00101"));
        System.out.println(solution(7, 3, "1101001").equals("0110101"));
        System.out.println(solution(4, 1, "1001").equals("0101"));
    }
}
