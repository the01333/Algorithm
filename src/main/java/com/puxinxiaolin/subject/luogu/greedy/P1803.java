package com.puxinxiaolin.subject.luogu.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Match implements Comparable<Match> {
    long start;
    long end;

    public Match(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Match o) {
        if (this.end != o.end) {
            return Long.compare(this.end, o.end);
        }
        return Long.compare(this.start, o.start);
    }
}

public class P1803 {
    /*
输入:
3
0 2
2 4
1 3

输出:
2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Match> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long start = sc.nextLong();
            long end = sc.nextLong();
            list.add(new Match(start, end));
        }
        sc.close();

        Collections.sort(list);

        long pos = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (pos <= list.get(i).start) {
                pos = list.get(i).end;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
