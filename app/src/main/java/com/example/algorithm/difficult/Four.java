package com.example.algorithm.difficult;

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
            if (p1.val <= p2.val) {
                result[m] = p1.val;
                if ((i + 1) < num1.length) {
                    p1.next = new ListNode(num1[i + 1]);
                    p1 = p1.next;
                    i++;
                }
            } else {
                result[m] = p2.val;
                if ((j + 1) < num2.length) {
                    p2.next = new ListNode(num2[j + 1]);
                    p2 = p2.next;
                    j++;
                }
            }
        }

        return result;
    }

    class ListNode {
        int val;
        Four.ListNode next;   // 下一个链表对象
        ListNode(int x) { val = x; }  //赋值链表的值
    }
}
