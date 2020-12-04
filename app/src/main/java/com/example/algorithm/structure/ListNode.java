package com.example.algorithm.structure;

public class ListNode {

    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public static ListNode createListFromArray(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int num:nums) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return head.next;
    }
}
