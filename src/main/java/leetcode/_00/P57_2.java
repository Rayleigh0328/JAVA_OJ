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
public class P57_2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        LinkedList<IInterval<Integer>> a = Arrays.stream(intervals)
            .map(IntervalHelper::mapIntArrayToInterval)
            .collect(Collectors.toCollection(LinkedList::new));
        IInterval<Integer> toMerge = IntervalHelper.mapIntArrayToInterval(newInterval);

        LinkedList<IInterval<Integer>> left = new LinkedList<>();
        while (!a.isEmpty() && IntervalHelper.onLeft(a.peekFirst(), toMerge)) {
            left.add(a.pollFirst());
        }

        LinkedList<IInterval<Integer>> right = new LinkedList<>();
        while (!a.isEmpty() && IntervalHelper.onRight(a.peekLast(), toMerge)) {
            right.addFirst(a.pollLast());
        }

        while (!a.isEmpty()) {
            toMerge = IntervalHelper.mergeInterval(toMerge, a.pollFirst());
        }

        List<IInterval<Integer>> result = new LinkedList<>();
        result.addAll(left);
        result.add(toMerge);
        result.addAll(right);
        return result.stream().map(IntervalHelper::mapIntervalToIntArray).toArray(int[][]::new);
    }
}
