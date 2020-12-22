package com.example.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FourHundredAndSix {

    // 从高到低考虑
    // 时间复杂度：O(n2)
    // 空间复杂度：O(n2)
    public int[][] reconstructQueue (int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare (int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1]:o2[0] - o1[0];
            }
        });

        for (int[] person : people) {
            System.out.println("====" + Arrays.toString(person));
        }

        List<int[]> queue = new ArrayList<>();
        for (int[] person : people) {
            queue.add(person[1],person);
        }

        return queue.toArray(new int[queue.size()][]);
    }
}