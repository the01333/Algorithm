package com.puxinxiaolin.subject.lanqiao.javaB2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P3 {
    // 第一个是主队列，剩下的都是从队列
    static List<List<Integer>> q = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            q.add(new ArrayList<>());
        }

        while (sc.hasNextLine()) {
            String s = sc.next();
            if (s.equals("add")) {
                q.get(0).add(sc.nextInt());
            } else if (s.equals("sync")) {
                int followerQNum = sc.nextInt();
                if (q.get(followerQNum).size() < q.get(0).size()) {
                    q.get(followerQNum).add(1);
                }
            } else {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    min = Math.min(min, q.get(i).size());
                }
                System.out.println(min);
            }
        }
    }
}
