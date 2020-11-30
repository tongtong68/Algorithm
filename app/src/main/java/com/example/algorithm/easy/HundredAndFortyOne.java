package com.example.algorithm.easy;

import com.example.algorithm.structure.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HundredAndFortyOne {


    // 时间复杂度：O(N)
    // 空间复杂度：O(N)
    public boolean hasCycle(ListNode head) {
        Map<Integer, Integer> result = new HashMap<>();
        while (null != head) {
            if (!result.containsKey(head.value)) {
                result.put(head.value, head.value);
            } else {
                return true;
            }
            head = head.next;
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // 时间复杂度：O(N)
    // 空间复杂度：O(1)
    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
