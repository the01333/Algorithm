package com.puxinxiaolin.subject.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // 数和出现的频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 初始的众数
        int key = -1;
        int maxVal = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxVal || (entry.getValue() == maxVal && entry.getKey() < key)) {
                maxVal = entry.getValue();
                key = entry.getKey();
            }
        }

        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            // 把当前的众数给到数组 b 中
            b[i] = key;
            // 根据遍历的顺序决定当前要删除的 a[i]，把 a[i] 进行移除或减少频率
            int removedNum = a[i];
            int removedKey = map.get(removedNum);
            if (removedKey == 1) {
                map.remove(removedNum);
            } else {
                map.put(removedNum, removedKey - 1);
            }

            // 如果删除的是当前的众数，需要重新计算众数
            if (removedNum == key) {
                maxVal = 0;
                key = -1;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > maxVal || (entry.getValue() == maxVal && entry.getKey() < key)) {
                        maxVal = entry.getValue();
                        key = entry.getKey();
                    }
                }
            }
        }

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        sc.close();
    }
}
