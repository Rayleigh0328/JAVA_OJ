package leetcode._04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class P435_2 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 1) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        int f [] = new int [intervals.length];
        f[0] = 1;
        mp.put(intervals[0][1], 0);
        for (int i=1;i<intervals.length;++i){
            f[i] = f[i-1];
            Map.Entry<Integer, Integer> entry = mp.floorEntry(intervals[i][0]);
            if (entry != null) {
                f[i] = Math.max(f[i], f[entry.getValue()] + 1);
            }
            mp.put(intervals[i][1], i);
        }
        return intervals.length - f[intervals.length-1];
    }
}
