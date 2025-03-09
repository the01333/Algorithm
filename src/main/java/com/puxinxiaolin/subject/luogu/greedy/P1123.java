package com.puxinxiaolin.subject.luogu.greedy;

import java.util.*;

class Person implements Comparable<Person> {
    int id;
    int time;

    Person(int id, int time) {
        this.id = id;
        this.time = time;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.time, o.time);
    }
}

public class P1123{
    /*
    10
56 12 1 99 1000 234 33 55 99 812
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Person> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int time = sc.nextInt();
            list.add(new Person(i, time));
        }
        sc.close();

        Collections.sort(list);
        // 排队顺序
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(list.get(i).id);
        }
        System.out.println(sb);

        // 平均等待时间
        long sumWaitTime = 0L;
        long curWaitTime = 0L;
        for (int i = 0; i < n - 1; i++) {
            curWaitTime += list.get(i).time;
            sumWaitTime += curWaitTime;
        }
        double ans = (double) sumWaitTime / n;
        System.out.printf("%.2f", ans);
    }
}
