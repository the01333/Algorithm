package com.puxinxiaolin.subject.leetcode.easyStart;

public class AddEachDigits {
    public static int addDigits(int num) {
        String s = String.valueOf(num);
        if (s.length() == 1) {
            return Integer.parseInt(s);
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return addDigits(res);
    }

    public static int addDigits2(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits2(38) == 2);
        System.out.println(addDigits2(0) == 0);
    }
}
