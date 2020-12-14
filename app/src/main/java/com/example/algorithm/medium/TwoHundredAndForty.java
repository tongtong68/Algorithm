package com.example.algorithm.medium;

public class TwoHundredAndForty {

    // 方法一：暴力法
    // 时间复杂度：O(mn)
    // 空间复杂度：O(1)
    public boolean searchMatrix(int[][] nums, int target) {
        boolean result = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (target == nums[i][j]) {
                    result = true;
                }
            }
        }

        return result;
    }

    // 时间复杂度：O(n+m)
    // 空间复杂度：O(1)
    public boolean searchMatrix1(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }
}