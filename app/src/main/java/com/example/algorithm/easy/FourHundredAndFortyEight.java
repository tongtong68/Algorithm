package com.example.algorithm.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FourHundredAndFortyEight {
    private int[] a = new int[]{4, 3, 2, 7, 8, 2, 3, 1};

    // 方法一：使用哈希表
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public List<Integer> getNums(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> temp = new HashSet<>();
        for (Integer num : nums) {
            temp.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!temp.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    // 方法二：原地修改
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {

        // Iterate over each of the elements in the original array
        for (int i = 0; i < nums.length; i++) {

            // Treat the value as the new index
            int newIndex = Math.abs(nums[i]) - 1;

            // Check the magnitude of value at this new index
            // If the magnitude is positive, make it negative
            // thus indicating that the number nums[i] has
            // appeared or has been visited.
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        // Response array that would contain the missing numbers
        List<Integer> result = new LinkedList<Integer>();

        // Iterate over the numbers from 1 to N and add all those
        // that have positive magnitude in the array
        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;
    }
}
