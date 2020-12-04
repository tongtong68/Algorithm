package com.example.algorithm.easy;

import com.example.algorithm.structure.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class TwoHundredAndSix {

    public ListNode getReverse(ListNode head) {
        Deque stack = new LinkedList<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode head1 = new ListNode(0);
        ListNode current = head1;
        while (stack.peek() != null) {
            current.next = (ListNode) stack.peek();
            stack.pop();
            current = current.next;
        }
        current.next = null;
        return head1.next;
    }

    // 方法一：迭代
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // 方法二：递归
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
