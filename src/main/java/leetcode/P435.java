package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class P435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));
        int cur = Integer.MIN_VALUE;
        int s,t;
        int selectedCount = 0;
        for (int[] interval : intervals) {
            s = interval[0];
            t = interval[1];
            if (s >= cur) {
                cur = t;
                ++selectedCount;
            }
        }
        return intervals.length - selectedCount;
    }
}
