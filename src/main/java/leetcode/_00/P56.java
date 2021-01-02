package leetcode._00;

import lib.interval.IInterval;
import lib.interval.Interval;
import lib.interval.IntervalHelper;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class P56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        LinkedList<IInterval> a =
            Arrays.stream(intervals).map(x -> new Interval<>(x[0], x[1]))
                .collect(Collectors.toCollection(LinkedList::new));
        List<IInterval> result = new LinkedList<>();
        while (!a.isEmpty()){
            IInterval cur = a.pollFirst();
            while (!a.isEmpty() && IntervalHelper.isClosedIntervalOverlap(cur, a.peekFirst())){
                cur = IntervalHelper.mergeInterval(cur,a.pollFirst());
            }
            result.add(cur);
        }
        return result.stream().map(interval -> {
            int[] tmp = new int[2];
            tmp[0] = (int) interval.getLeft();
            tmp[1] = (int) interval.getRight();
            return tmp;
        }).toArray(int[][]::new);
    }
}
