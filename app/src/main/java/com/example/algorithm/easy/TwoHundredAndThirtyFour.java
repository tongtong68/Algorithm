package com.example.algorithm.easy;

import com.example.algorithm.structure.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class TwoHundredAndThirtyFour {

    private ListNode frontPointer;

    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public boolean isReverseWord(ListNode node) {
        Deque<Integer> stack = new LinkedList<>();
        while (node != null) {
            if (stack.isEmpty() || (stack.peek() != node.value)) {
                stack.push(node.value);
            } else {
                stack.pop();
            }
            node = node.next;
        }

        return stack.isEmpty();
    }


    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.value != frontPointer.value) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    // 方法三：快慢指针
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.value != p2.value) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
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

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}