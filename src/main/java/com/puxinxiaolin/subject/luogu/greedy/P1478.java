package com.puxinxiaolin.subject.luogu.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

class Apple {
    int x;   // 苹果高度
    int y;   // 摘苹果所需的力气

    public Apple(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class P1478 {
    /*
输入:
8 15
20 130
120 3
150 2
110 7
180 1
50 8
200 0
140 3
120 2

输出:
4
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 苹果总数
        int s = sc.nextInt();   // 力气
        int a = sc.nextInt();   // 椅子的高度
        int b = sc.nextInt();   // 手伸直的长度
        List<Apple> apples = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            apples.add(new Apple(x, y));
        }
        sc.close();

        List<Integer> s1 = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.x <= a + b) {
                s1.add(apple.y);
            }
        }
        s1.sort(Comparator.comparingInt(y -> y));
        int ans = 0;
        for (Integer y : s1) {
            if (s >= y) {
                ans++;
                s -= y;
            } else {
                break;
            }
        }
        System.out.println(ans);
    }
}
