package com.puxinxiaolin.subject.luogu.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @description: 优先级队列（最小堆）, 确保每次获取都是最小的值
 * @author: YCcLin
 * @date: 2025/2/9
 **/
public class P1090 {
    /*
输入:
3
1 2 9

输出:
15
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 最小堆: 内部默认排序, 每次取出的都是最小的（如果要变成最大堆只需要在构造参数里加上排序器 Comparator.reverseOrder() ）
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }
        sc.close();

        int ans = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int sum = a + b;
            ans += sum;
            pq.add(a + b);
        }
        System.out.println(ans);
    }
}
