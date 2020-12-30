package com.example.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FiveHundredAndEightyOne {

    private int[] a = new int[]{5, 10, 9, 3, 7, 2};


    // 方法 3：排序
    // 时间复杂度：O(nlogn)
    // 空间复杂度：O(n)
    public int findUnsortedSubarray(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] copyArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyArray);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copyArray[i]) {
                result.add(i);
            }
        }

        return result.isEmpty() ? 0 : result.get(result.size() - 1) - (result.get(0) - 1);
    }


    // 方法 4：使用栈
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public int findUnsortedSubarray2(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }

    // 方法 5：不使用额外空间
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int findUnsortedSubarray3(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}