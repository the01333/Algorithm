package com.puxinxiaolin.subject.lanqiaoCloudCourse;

import java.util.LinkedList;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            switch (s) {
                case "push" -> {
                    int x = sc.nextInt();
                    stack.push(x);
                }
                case "query" -> {
                    if (!stack.isEmpty()) {
                        System.out.println(stack.peek());
                    } else {
                        System.out.println("empty");
                    }
                }
                case "pop" -> {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
                case "empty" -> {
                    if (!stack.isEmpty()) {
                        System.out.println("NO");
                    } else {
                        System.out.println("YES");
                    }
                }
            }
        }
        sc.close();
    }
}
