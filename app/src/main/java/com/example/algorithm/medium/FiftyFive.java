package com.example.algorithm.medium;

public class FiftyFive {

    int[] nums = new int[]{1, 3, 5, 3, 0, 7, 3};

    public boolean canJump() {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canJump2() {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1)
            return true;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                boolean b = foo(nums, i);
                if (b == false)
                    return false;
            }
        }
        return true;
    }

    private boolean foo(int[] nums, int ind) {
        int tmp = ind;
        if (ind == nums.length - 1)
            tmp--;
        for (int i = ind - 1; i >= 0; i--) {
            if (nums[i] > tmp - i) {
                return true;
            }
        }
        return false;
    }
}
