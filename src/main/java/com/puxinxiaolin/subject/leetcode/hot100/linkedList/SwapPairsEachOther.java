package com.puxinxiaolin.subject.leetcode.hot100.linkedList;

public class SwapPairsEachOther {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result1 = swapPairs(l1);
        while (result1 != null) {
            System.out.print(result1.val + " ");
            result1 = result1.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // before       current            next
        //   t     ->     head      ->     next      ->    .....
        ListNode t = new ListNode(0);
        t.next = head;
        ListNode before = t;
        ListNode current = head;

        while (current != null && current.next != null) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = current;
            before.next = next;

            before = current;
            current = current.next;
        }
        return t.next;
    }
}
