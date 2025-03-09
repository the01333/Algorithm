package com.puxinxiaolin.subject.leetcode.easyStart;

public class VowelStrings {
    static String vowels = "aeiou";

    public static int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (vowels.indexOf(word.charAt(0)) != -1 && vowels.indexOf(word.charAt(word.length() - 1)) != -1) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(vowelStrings(new String[]{"are","amy","u"}, 0, 2) == 2);
        System.out.println(vowelStrings(new String[]{"hey","aeo","mu","ooo","artro"}, 1, 4) == 3);
    }

}
