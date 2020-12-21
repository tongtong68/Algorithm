package com.example.algorithm.medium;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ThreeHundredAndFortySeven {

    private int[] nums = new int[]{1, 1, 1, 2, 2, 3};

    // 哈希+排序
    // 时间复杂度：O(NlogN)
    // 空间复杂度：O(N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int[] getHighestFrequencyNum(int[] nums, int k) {
        List<Integer> result = new ArrayList();
        int[] resultInt = new int[k];
        Map<Integer, Integer> temp = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            if (temp.containsKey(num)) {
                int times = temp.get(num);
                temp.put(num, ++times);
            } else {
                temp.put(num, 1);
            }
        }

        List<Integer> resultNoSort = new ArrayList<>(temp.values());
        Collections.sort(resultNoSort);

        Set<Map.Entry<Integer, Integer>> entrySet = temp.entrySet();
        Iterator<Map.Entry<Integer, Integer>> it2 = entrySet.iterator();
        while (it2.hasNext()) {
            Map.Entry<Integer, Integer> me = it2.next();
            int key2 = me.getKey();//通过关系对象获取key
            int value2 = me.getValue();//通过关系对象获取value
            for (int i = 0; i < k; i++) {
                if (value2 == resultNoSort.get(resultNoSort.size() - 1 - i)) {
                    result.add(key2);
                    break;
                }
            }
        }

        for (int i = 0; i< result.size();i++) {
            resultInt[i] = result.get(i);
        }
        return resultInt;
    }

    // 方法一：堆
    // 时间复杂度：O(Nlogk)
    // 空间复杂度：O(N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        int[] ret = new int[k];
        qsort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }
}