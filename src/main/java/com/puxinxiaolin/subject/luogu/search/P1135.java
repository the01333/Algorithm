package com.puxinxiaolin.subject.luogu.search;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
    int floor;
    int presses;   // 按键次数

    public Node(int floor, int presses) {
        this.floor = floor;
        this.presses = presses;
    }
}

public class P1135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] k = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            k[i] = sc.nextInt();
        }
        sc.close();

        LinkedList<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.offer(new Node(a, 0));
        visited[a] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.floor == b) {
                System.out.println(curr.presses);
                return;
            }

            int upFloor = curr.floor + k[curr.floor];
            if (upFloor >= 1 && upFloor <= n && !visited[upFloor]) {
                q.offer(new Node(upFloor, curr.presses + 1));
                visited[upFloor] = true;
            }

            int downFloor = curr.floor - k[curr.floor];
            if (downFloor >= 1 && downFloor <= n && !visited[downFloor]) {
                q.offer(new Node(downFloor, curr.presses + 1));
                visited[downFloor] = true;
            }
        }

        System.out.println(-1);
    }
}
