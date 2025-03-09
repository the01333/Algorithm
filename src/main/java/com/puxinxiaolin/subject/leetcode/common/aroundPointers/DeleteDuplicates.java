package com.puxinxiaolin.subject.leetcode.common.aroundPointers;

import com.puxinxiaolin.subject.leetcode.common.reversedLinkedList.ListNode;

import java.util.Objects;

public class DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p1 = dummy;
        ListNode p2, p3;
        //  p1    p2    p3
        // dummy  [ ... ]
        while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
            if (p2.val == p3.val) {
                while (p3 != null && p2.val == p3.val) {
                    p3 = p3.next;
                }
                p1.next = p3;
            } else {
                p1 = p1.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5))))))));
        System.out.println(Objects.equals(node, new ListNode(1, new ListNode(2, new ListNode(5)))));
    }
}
