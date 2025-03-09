package com.puxinxiaolin.subject.leetcode.common.reversedLinkedList;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
