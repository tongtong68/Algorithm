package com.example.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FiftySix {

    int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}};

    public int[][] getResult(int[][] intervals) {
        int[][] result = new int[][]{};

        return result;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int Left = intervals[i][0], Right = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < Left) {
                merged.add(new int[]{Left, Right});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], Right);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
