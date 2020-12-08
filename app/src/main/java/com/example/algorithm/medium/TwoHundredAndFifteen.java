package com.example.algorithm.medium;

import java.util.Random;

public class TwoHundredAndFifteen {

    Random random = new Random();


    // 时间复杂度：O(n)
    // 空间复杂度：O(logn)
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int length, int right, int index) {
        int q = randomPartition(a, length, right);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, right, index) : quickSelect(a, length, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(a, i, right);
        return partition1(a, left, right);
    }

    public int partition1(int[] a, int left, int right) {
        int x = a[right], i = left - 1;
        for (int j = left; j < right; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, right);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /**
     * 快速排序，使得整数数组 arr 有序
     */
    public void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序，使得整数数组 arr 的 [L, R] 部分有序
     */
    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // 把数组中随机的一个元素与最后一个元素交换，这样以最后一个元素作为基准值实际上就是以数组中随机的一个元素作为基准值
            swap(arr, new Random().nextInt(right - left + 1) + left, right);
            int[] p = partition(arr, left, right);
            quickSort(arr, left, p[0] - 1);
            quickSort(arr, p[1] + 1, right);
        }
    }

    /**
     * 分区的过程，整数数组 arr 的[L, R]部分上，使得：
     * 大于 arr[R] 的元素位于[L, R]部分的右边，但这部分数据不一定有序
     * 小于 arr[R] 的元素位于[L, R]部分的左边，但这部分数据不一定有序
     * 等于 arr[R] 的元素位于[L, R]部分的中间
     * 返回等于部分的第一个元素的下标和最后一个下标组成的整数数组
     */
    public int[] partition(int[] arr, int L, int R) {

        int basic = arr[R];
        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            if (arr[L] < basic) {
                swap(arr, ++less, L++);
            } else if (arr[L] > basic) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }

        return new int[]{less + 1, more - 1};

    }
}
