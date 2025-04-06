package com.puxinxiaolin.subject.lanqiao.javaB2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        while (sc.hasNext()) {
            String type = sc.next();
            if (type.equals("add")) {
                int num = sc.nextInt();
                list.get(0).add(num);
            } else if (type.equals("sync")) {
                int num = sc.nextInt();
                if (list.get(num).size() < list.get(0).size()) {
                    list.get(num).add(1);
                }
            } else {
                int ans = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    ans = Math.min(ans, list.get(i).size());
                }
                System.out.println(ans);
            }
        }
        sc.close();
    }
}
