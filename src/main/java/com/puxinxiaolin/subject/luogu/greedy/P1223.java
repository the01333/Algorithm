package com.puxinxiaolin.subject.luogu.greedy;

import java.util.*;

class P implements Comparable<P> {
    int id;
    int time;

    public P(int id, int time) {
        this.id = id;
        this.time = time;
    }

    @Override
    public int compareTo(P o) {
        return Integer.compare(this.time, o.time);
    }
}

public class P1223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<P> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int t = sc.nextInt();
            list.add(new P(i, t));
        }
        sc.close();

        // 排名
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(list.get(i).id);
        }
        System.out.println(sb);

        // 时间
        long ans = 0L, res = 0L;
        for (int i = 0; i < n - 1; i++) {
            res += list.get(i).time;
            ans += res;
        }

        System.out.printf("%.2f", (double) ans / n);
    }
}
