package com.example.algorithm.difficult;

import com.example.algorithm.structure.ListNode;

public class Four {
    private int[] num1;
    private int[] num2;

    // 归并排序，时间复杂度 O(m + n)
    public int[] merge(int[] num1, int[] num2) {
        int[] result = new int[num1.length + num2.length];
        int i = 0;
        int j = 0;
        ListNode p1 = new ListNode(num1[i]);
        ListNode p2 = new ListNode(num2[j]);
        for (int m = 0; m < num1.length + num2.length; m++) {
            if (p1.value <= p2.value) {
                result[m] = p1.value;
                if ((i + 1) < num1.length) {
                    p1.next = new ListNode(num1[i + 1]);
                    p1 = p1.next;
                    i++;
                }
            } else {
                result[m] = p2.value;
                if ((j + 1) < num2.length) {
                    p2.next = new ListNode(num2[j + 1]);
                    p2 = p2.next;
                    j++;
                }
            }
        }

        return result;
    }
}
