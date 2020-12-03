package com.example.algorithm.easy;

import com.example.algorithm.structure.ListNode;

public class HundredAndSixty {

    // 方法三：双指针法
    // 时间复杂度 : O(m+n)
    // 空间复杂度 : O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode nodeP = headA;
        ListNode nodeQ = headB;

        // 当遍历到nodeP链表尾部时，那么直接接上headB上
        // 当遍历到nodeQ链表尾部时，那么直接接上headA上
        // 以此完成两个链表相加的逻辑操作。
        while (nodeP != nodeQ) {
            nodeP = nodeP == null ? headB : nodeP.next;
            nodeQ = nodeQ == null ? headA : nodeQ.next;
        }

        return nodeP;

    }
}
