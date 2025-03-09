package com.puxinxiaolin.subject.luogu.search;

import java.util.*;

/**
 * @Description: 字符变换
 * @Author: YccLin
 * @Date: 2024/11/24
 */
public class P1032 {
    static int minSteps = Integer.MAX_VALUE;
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String A = s.split(" ")[0];
        String B = s.split(" ")[1];

        // 存储变换规则
        Map<String, String> rules = new HashMap<>();
        // 规则数量，作输入的限制
        int ruleCount = 0;
        while (sc.hasNextLine() && ruleCount < 6) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                break;
            }
            String[] parts = line.split(" ");
            rules.put(parts[0], parts[1]);
            ruleCount++;
        }

        // 如果 A 和 B 一开始就是相等的
        if (A.equals(B)) {
            System.out.println(0);
            return;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(A);
        // 使用集合记录已经访问过的字符串
        Set<String> visited = new HashSet<>();
        visited.add(A);

        // 步数（答案）
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                // 相等
                if (cur.equals(B)) {
                    found = true;
                    minSteps = Math.min(minSteps, steps);
                    break;
                }
                // 不相等
                for (Map.Entry<String, String> rule : rules.entrySet()) {
                    String key = rule.getKey();
                    String value = rule.getValue();
                    String newStr = cur.replace(key, value);
                    // 变化后和原来不相等
                    if (!newStr.equals(cur) && !visited.contains(newStr)) {
                        q.offer(newStr);
                        visited.add(newStr);
                    }
                }
            }
            steps++;
            // 超过题目限制的步数
            if (steps > 10) {
                break;
            }
        }

        if (found) {
            System.out.println(minSteps);
        } else {
            System.out.println("NO ANSWER!");
        }
    }
}
