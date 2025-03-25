package com.puxinxiaolin.subject.luogu.sort;

import java.util.Scanner;

public class P1781 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int id = 0;
        String vote = "";

        for (int i = 1; i <= n; i++) {
            String s = sc.next();
            int sSize = s.length();
            int voteSize = vote.length();
            if (sSize > voteSize || (sSize == voteSize && s.compareTo(vote) > 0)) {
                vote = s;
                id = i;
            }
        }
        sc.close();

        System.out.println(id);
        System.out.println(vote);
    }
}
