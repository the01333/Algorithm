package com.puxinxiaolin.subject.leetcode.weekCompetion;

import java.util.*;

public class CountMentions {
    public static int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        Map<Integer, Integer> offlineUntil = new HashMap<>();   // 记录用户离线的时间

        // 按时间戳排序事件，时间相同的情况下，OFFLINE事件优先处理
        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            if (timeA != timeB) {
                return Integer.compare(timeA, timeB);
            } else {
                // 确保OFFLINE事件排在MESSAGE事件前面
                boolean aIsOffline = a.get(0).equals("OFFLINE");
                boolean bIsOffline = b.get(0).equals("OFFLINE");
                if (aIsOffline && !bIsOffline) {
                    return -1;
                } else if (!aIsOffline && bIsOffline) {
                    return 1;
                } else {
                    return 0; // 相同类型保持原顺序
                }
            }
        });

        for (List<String> event : events) {
            String messageType = event.get(0);
            int timeStamp = Integer.parseInt(event.get(1));
            String mentionedUser = event.get(2);

            // 处理离线用户的重新上线
            List<Integer> toRemove = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : offlineUntil.entrySet()) {
                if (entry.getValue() <= timeStamp) {
                    toRemove.add(entry.getKey());
                }
            }
            for (Integer userId : toRemove) {
                offlineUntil.remove(userId);
            }

            if (messageType.equals("MESSAGE")) {
                Set<Integer> mentionedUsers = new HashSet<>();    // 记录当前消息提及的用户

                if (mentionedUser.equals("ALL")) {
                    // 提及所有用户
                    for (int i = 0; i < numberOfUsers; i++) {
                        mentionedUsers.add(i);
                    }
                } else if (mentionedUser.equals("HERE")) {
                    // 提及所有在线用户
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (!offlineUntil.containsKey(i)) {
                            mentionedUsers.add(i);
                        }
                    }
                } else {
                    // 提及特定用户
                    String[] ids = mentionedUser.split(" ");
                    for (String id : ids) {
                        if (id.startsWith("id")) {
                            int userId = Integer.parseInt(id.substring(2));
                            mentionedUsers.add(userId);
                        }
                    }
                }

                // 更新提及次数
                for (Integer user : mentionedUsers) {
                    mentions[user]++;
                }
            } else if (messageType.equals("OFFLINE")) {
                int userId = Integer.parseInt(mentionedUser);
                offlineUntil.put(userId, timeStamp + 60);
            }
        }
        return mentions;
    }

    public static void main(String[] args) {
        // 示例 1
        int numberOfUsers1 = 2;
        List<List<String>> events1 = Arrays.asList(
                Arrays.asList("MESSAGE", "10", "id1 id0"),
                Arrays.asList("OFFLINE", "11", "0"),
                Arrays.asList("MESSAGE", "71", "HERE")
        );
        int[] result1 = countMentions(numberOfUsers1, events1);
        System.out.println(Arrays.toString(result1)); // 输出: [2, 2]

        // 示例 2
        int numberOfUsers2 = 2;
        List<List<String>> events2 = Arrays.asList(
                Arrays.asList("MESSAGE", "10", "id1 id0"),
                Arrays.asList("OFFLINE", "11", "0"),
                Arrays.asList("MESSAGE", "12", "ALL")
        );
        int[] result2 = countMentions(numberOfUsers2, events2);
        System.out.println(Arrays.toString(result2)); // 输出: [2, 2]

        // 示例 3
        int numberOfUsers3 = 2;
        List<List<String>> events3 = Arrays.asList(
                Arrays.asList("OFFLINE", "10", "0"),
                Arrays.asList("MESSAGE", "12", "HERE")
        );
        int[] result3 = countMentions(numberOfUsers3, events3);
        System.out.println(Arrays.toString(result3)); // 输出: [0, 1]

        // 示例 4
        int numberOfUsers = 3;
        List<List<String>> events = Arrays.asList(
                Arrays.asList("MESSAGE", "2", "HERE"),
                Arrays.asList("OFFLINE", "2", "1"),
                Arrays.asList("OFFLINE", "1", "0"),
                Arrays.asList("MESSAGE", "61", "HERE")
        );
        int[] result = countMentions(numberOfUsers, events);
        System.out.println(Arrays.toString(result)); // 输出: [2, 2, 2]
    }
}
