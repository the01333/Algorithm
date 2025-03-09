package com.puxinxiaolin.subject.leetcode.common.fastAndSlowPointer;

import com.puxinxiaolin.subject.leetcode.common.reversedLinkedList.ListNode;

import java.util.Objects;

public class MiddleNode {
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(Objects.equals(middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))),
                new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(Objects.equals(middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))),
                new ListNode(4, new ListNode(5, new ListNode(6)))));
    }
}
