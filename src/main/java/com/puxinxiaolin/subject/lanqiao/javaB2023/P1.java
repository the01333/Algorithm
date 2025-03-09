package com.puxinxiaolin.subject.lanqiao.javaB2023;

/**
 * @description: 令 S = 1! + 2! + 3! + ... + 202320232023! ，求 S 的末尾 9 位数字
 * @author: YCcLin
 * @date: 2025/1/4
 **/
public class P1 {
    static final long MOD = 1_000_000_000;
    static final long MAX_N = 202320232023L;

    public static void main(String[] args) {
        Long ans = 0L;
        for (long i = 1; i <= MAX_N; i++) {
            ans = (ans + factorial(i)) % MOD;
            if (factorial(i) % MOD == 0) {    // 阶层后面 0 会很多，只要超过九位可以提前终止
                break;
            }
        }
        System.out.println(ans);
    }

    private static Long factorial(long n) {
        long ans = 1L;
        for (int i = 1; i <= n; i++) {
            ans = (ans * i) % MOD;
        }
        return ans;
    }
}
