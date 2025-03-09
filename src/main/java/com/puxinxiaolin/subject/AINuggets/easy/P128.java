package com.puxinxiaolin.subject.AINuggets.easy;

public class P128 {
    public static String solution(String inp) {
        int maxStart = 0;
        int maxLength = 0;

        for (int i = 0; i < inp.length(); i++) {
            int j = i;
            while (j + 1 < inp.length() && inp.charAt(j) != inp.charAt(j + 1)) {
                j++;
            }
            if (j - i + 1 >= 3 && j - i + 1 > maxLength) {
                maxStart = i;
                maxLength = j - i + 1;
            }
        }

        return inp.substring(maxStart, maxStart + maxLength);
    }

    public static void main(String[] args) {
        System.out.println(solution("0101011101").equals("010101"));
        System.out.println(solution("1110101010000").equals("10101010"));
        System.out.println(solution("1010101010101010").equals("1010101010101010"));
    }
}
