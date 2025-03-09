package com.puxinxiaolin.subject.chuanZhiCup;

import java.util.Scanner;

/**
 * @Description: 红色和紫色
 * @Author: YccLin
 * @Date: 2024/11/25
 */
public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if ((n * m) % 2 == 0) {
            System.out.println("yukari");
        } else {
            System.out.println("akai");
        }
    }
}
