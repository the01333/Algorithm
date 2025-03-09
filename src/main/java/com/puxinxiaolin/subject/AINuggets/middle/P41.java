package com.puxinxiaolin.subject.AINuggets.middle;

public class P41 {
    public static int solution(String input) {
        int[] count = new int[4];   // 0:A, 1:S, 2:D, 3:F
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'A') count[0]++;
            else if (c == 'S') count[1]++;
            else if (c == 'D') count[2]++;
            else if (c == 'F') count[3]++;
        }

        int averLen = input.length() / 4;
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            if (count[i] > averLen) {
                ans += count[i] - averLen;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution("ADDF") == 1);
        System.out.println(solution("ASAFASAFADDD") == 3);
        System.out.println(solution("SSDDFFFFAAAS") == 1);
        System.out.println(solution("AAAASSSSDDDDFFFF") == 0);
        System.out.println(solution("AAAADDDDAAAASSSS") == 4);
        System.out.println(solution("AFSSSSFFSSDSAFSSDFSF") == 7);
    }
}
