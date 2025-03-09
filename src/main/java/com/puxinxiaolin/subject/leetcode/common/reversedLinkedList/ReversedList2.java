package com.puxinxiaolin.subject.leetcode.common.reversedLinkedList;

import java.util.Objects;

public class ReversedList2 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }

        ListNode pre = null;
        ListNode cur = p0.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(Objects.equals(reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4), new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5)))))));
        System.out.println(Objects.equals(reverseBetween(new ListNode(5), 1, 1), new ListNode(5)));
    }
}
