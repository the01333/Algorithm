package com.puxinxiaolin.subject.lanqiao.javaB2023;

/**
 * @description: 哈沙德数是指在某个固定的进位制当中，可以被各位数字之和整除的正整数。
 * 例如 126 是十进制下的一个哈沙德数，因为 (126) 10 mod (1+2+6) = 0 ；
 * 126 也是八进制下的哈沙德数，因为 (126) 10 = (176) 8 ， (126) 10 mod (1 + 7 + 6) = 0 ；
 * 同时 126 也是 16 进制下的哈沙德数，因为 (126) 10 = (7 e ) 16 ， (126) 10 mod (7 + e ) = 0 。
 * 小蓝认为，如果一个整数在二进制、八进制、十进制、十六进制下均为 哈沙德数，那么这个数字就是幸运数字，
 * 第 1 至第 10 个幸运数字的十进制表示 为：1 , 2 , 4 , 6 , 8 , 40 , 48 , 72 , 120 , 126 . . . 。
 * 现在他想知道第 2023 个幸运数 字是多少？你只需要告诉小蓝这个整数的十进制表示即可
 * @author: YCcLin
 * @date: 2025/1/4
 **/
public class P2 {
    public static void main(String[] args) {
        int j = 0;
        for (int i = 1; ; i++) {
            if (judge(i)) {
                j++;
                if (j == 2023) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    private static boolean judge(int n) {
        // 十进制
        if (!convertByBase(n, 10)) {
            return false;
        }

        // 二进制
        if (!convertByBase(n, 2)) {
            return false;
        }

        // 八进制
        if (!convertByBase(n, 8)) {
            return false;
        }

        // 十六进制
        if (!convertByBase(n, 16)) {
            return false;
        }

        return true;
    }

    // 进制转换模版
    private static boolean convertByBase(int n, int base) {
        int sum = 0, x = n;
        while (x != 0) {
            sum += x % base;
            x /= base;
        }
        return n % sum == 0;
    }
}
