package com.puxinxiaolin.subject.leetcode.common.reversedLinkedList;

import java.util.Objects;

public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode result = null;
        while (p != null) {
            result = new ListNode(p.val, result);
            p = p.next;
        }
        return result;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(Objects.equals(reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))),
                new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))))));
        System.out.println(Objects.equals(reverseList(new ListNode(1, new ListNode(2))),
                new ListNode(2, new ListNode(1))));
        System.out.println(Objects.equals(reverseList2(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))),
                new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))))));
        System.out.println(Objects.equals(reverseList2(new ListNode(1, new ListNode(2))),
                new ListNode(2, new ListNode(1))));
    }
}
