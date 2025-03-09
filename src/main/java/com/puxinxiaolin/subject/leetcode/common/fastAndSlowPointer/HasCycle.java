package com.puxinxiaolin.subject.leetcode.common.fastAndSlowPointer;

import com.puxinxiaolin.subject.leetcode.common.reversedLinkedList.ListNode;

public class HasCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(hasCycle(node1));

        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        node5.next = node6;
        node6.next = node5;
        System.out.println(hasCycle(node5));

        System.out.println(!hasCycle(new ListNode(1)));
    }
}
