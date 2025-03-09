package com.puxinxiaolin.subject.AINuggets.easy;

public class P29 {
    /*
        a->bc
        b->ca
        c->ab
        abc bccaab caababbcbcca
     */
    public static String solution(String s, int k) {
        StringBuilder ans = new StringBuilder(s);
        while (k-- > 0) {
            StringBuilder res = new StringBuilder();
            for (char c : ans.toString().toCharArray()) {
                switch (c) {
                    case 'a' -> res.append("bc");
                    case 'b' -> res.append("ca");
                    case 'c' -> res.append("ab");
                }
            }
            ans = res;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("abc", 2).equals("caababbcbcca"));
        System.out.println(solution("abca", 3).equals("abbcbccabccacaabcaababbcabbcbcca"));
        System.out.println(solution("cba", 1).equals("abcabc"));
    }
}
