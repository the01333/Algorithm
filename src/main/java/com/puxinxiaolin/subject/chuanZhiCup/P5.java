package com.puxinxiaolin.subject.chuanZhiCup;

import java.util.*;

/**
 * @Description: kotori和素因子
 * @Author: YccLin
 * @Date: 2024/11/26
 */
public class P5 {
    static Set<Integer> primes = new HashSet<>();
    static boolean[] isPrime = new boolean[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(getCount(a));
    }

    private static int getCount(int[] a) {
        generatePrimes();

        int ans = 0;
        Set<Integer> chosenPrime = new HashSet<>();
        for (int n : a) {
            boolean found = false;
            for (Integer prime : primes) {
                if (n % prime == 0 && !chosenPrime.contains(prime)) {
                    chosenPrime.add(prime);
                    ans += prime;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return -1;
            }
        }
        return ans;
    }

    private static void generatePrimes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= 1000; i++) {
            if (isPrime[i]) {
                primes.add(i);
                // 质数的平方不是质数
                for (int j = i * i; j <= 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
