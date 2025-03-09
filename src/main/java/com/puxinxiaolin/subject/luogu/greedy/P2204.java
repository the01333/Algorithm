package com.puxinxiaolin.subject.luogu.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GoldCoin {
    int weight;
    int value;

    public GoldCoin(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class P2204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bags = sc.nextInt();

        List<GoldCoin> goldCoins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            GoldCoin goldCoin = new GoldCoin(w, v);
            goldCoins.add(goldCoin);
        }
        sc.close();

        // dealing
        goldCoins.sort((o1, o2) ->
                Double.compare((double) o2.value / o2.weight, (double) o1.value / o1.weight));

        double ans = 0;
        for (int i = 0; i < n; i++) {
            if (bags <= goldCoins.get(i).weight) {
                ans += ((double) goldCoins.get(i).value / goldCoins.get(i).weight) * bags;
                break;
            } else {
                ans += goldCoins.get(i).value;
                bags -= goldCoins.get(i).weight;
            }
        }

        System.out.printf("%.2f", ans);
    }
}
