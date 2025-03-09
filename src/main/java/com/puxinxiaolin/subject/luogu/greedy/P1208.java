package com.puxinxiaolin.subject.luogu.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Farmer implements Comparable<Farmer> {
    int perPrice;
    int totalNum;

    public Farmer(int perPrice, int totalNum) {
        this.perPrice = perPrice;
        this.totalNum = totalNum;
    }

    @Override
    public int compareTo(Farmer o) {
        if (this.perPrice != o.perPrice) {
            return Integer.compare(this.perPrice, o.perPrice);
        }
        return Integer.compare(o.totalNum, this.totalNum);
    }
}

public class P1208 {
    /*
输入:
100 5
5 20
9 40
3 10
8 80
6 30

输出:
630
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 需要牛奶的总量
        int m = sc.nextInt();   // 提供牛奶的农民个数
        List<Farmer> farmers = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int perPrice = sc.nextInt();
            int totalNum = sc.nextInt();
            farmers.add(new Farmer(perPrice, totalNum));
        }
        sc.close();

        // 按价格升序排序, 如果一样按总量降序排序
        Collections.sort(farmers);

        int i = 0;
        int ans = 0;
        while (n > 0) {
            if (farmers.get(i).totalNum != 0) {
                farmers.get(i).totalNum--;
                ans += farmers.get(i).perPrice;
                n--;
            } else {
                i++;
            }
        }

        System.out.println(ans);
    }
}
