package com.puxinxiaolin.subject.luogu.greedy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class People implements Comparable<People> {
    int leftHand;
    int rightHand;

    public People(int leftHand, int rightHand) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
    }

    @Override
    public int compareTo(People o) {
        return Integer.compare(this.leftHand * this.rightHand, o.leftHand * o.rightHand);
    }
}

public class P1080 {
    /*
输入:
3
1 1
2 3
7 4
4 6

输出:
2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<People> peoples = new ArrayList<>();

        // 读取国王的左右手数字
        int kingLeft = sc.nextInt();
        int kingRight = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int leftHand = sc.nextInt();
            int rightHand = sc.nextInt();
            peoples.add(new People(leftHand, rightHand));
        }
        sc.close();

        Collections.sort(peoples);

        // 排在当前大臣前面所有人的左手乘积和
        BigInteger res = BigInteger.valueOf(kingLeft);
        BigInteger ans = BigInteger.ZERO;


        for (People people : peoples) {
            BigInteger reward = res.divide(BigInteger.valueOf(people.rightHand));
            ans = ans.max(reward);
            res = res.multiply(BigInteger.valueOf(people.leftHand));
        }

        System.out.println(ans);
    }
}
