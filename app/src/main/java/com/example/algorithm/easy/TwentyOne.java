package com.example.algorithm.easy;

import com.example.algorithm.structure.ListNode;

public class TwentyOne {

    // 迭代算法
    // 时间复杂度 O(m + n)
    // 空间复杂度 O(1)
    public ListNode merge1(ListNode l1, ListNode l2) {
        ListNode preResult = new ListNode(0);
        ListNode result = preResult;

        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }

        result.next = (l1 == null?l2 : l1);
        return preResult.next;
    }

    // 递归
    // 时间复杂度 O(m + n)
    // 空间复杂度 O(m + n)
    public ListNode merge2(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        } else if (a.value < b.value) {
            a.next = merge2(a.next,b);
            return a;
        } else {
            b.next = merge2(a, b.next);
            return b;
        }
    }
}
