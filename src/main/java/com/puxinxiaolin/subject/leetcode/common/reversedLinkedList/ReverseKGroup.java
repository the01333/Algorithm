package com.puxinxiaolin.subject.leetcode.common.reversedLinkedList;

import java.util.Objects;

public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        // 获取链表长度
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        // 哨兵 p0
        ListNode dummy = new ListNode(-1, head);
        ListNode p0 = dummy;

        // 当剩下的节点数大于 k，每次循环交换 k 个节点
        while (n >= k) {
            n -= k;
            ListNode pre = null;
            cur = p0.next;
            for (int i = 0; i < k; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            // 在交换之前我们还需要更新哨兵 p0 的位置，新位置为当前组要反转的第一个元素的上一个节点，也就是哨兵 p0 的下一个节点
            ListNode next = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(Objects.equals(reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2), new ListNode(2, new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(5)))))));
        System.out.println(Objects.equals(reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3), new ListNode(3, new ListNode(2, new ListNode(1, new ListNode(4, new ListNode(5)))))));
    }
}
