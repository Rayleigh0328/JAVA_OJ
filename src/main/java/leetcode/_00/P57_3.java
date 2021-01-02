package leetcode._00;

import lib.interval.IInterval;
import lib.interval.IntervalHelper;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/
 */
public class P57_3 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        LinkedList<IInterval<Integer>> a = Arrays.stream(intervals)
            .map(IntervalHelper::mapIntArrayToInterval)
            .collect(Collectors.toCollection(LinkedList::new));
        IInterval<Integer> toMerge = IntervalHelper.mapIntArrayToInterval(newInterval);


        List<IInterval<Integer>> result = new LinkedList<>();
        result.addAll(
            a.stream()
            .filter(x -> IntervalHelper.onLeft(x, toMerge))
            .collect(Collectors.toList())
        );
        result.add(
            a.stream()
            .filter(x -> IntervalHelper.isClosedIntervalOverlap(x, toMerge))
            .reduce(toMerge, IntervalHelper::mergeInterval)
        );
        result.addAll(
            a.stream()
                .filter(x -> IntervalHelper.onRight(x, toMerge))
                .collect(Collectors.toList())
        );
        return result.stream().map(IntervalHelper::mapIntervalToIntArray).toArray(int[][]::new);
    }
}
