package com.puxinxiaolin.subject.primeNumber;

/**
 * @description: 求质数
 * @author: YCcLin
 * @date: 2025/3/2
 **/
public class PrimeNumber {
    public Boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
