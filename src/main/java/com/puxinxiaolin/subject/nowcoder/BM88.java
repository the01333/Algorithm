package com.puxinxiaolin.subject.nowcoder;

public class BM88 {
    public boolean judge (String str) {
        if (str.length() == 1) {
            return true;
        }

        int n = str.length();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
