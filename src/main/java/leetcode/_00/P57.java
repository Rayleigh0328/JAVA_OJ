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
public class P57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        LinkedList<IInterval<Integer>> a = Arrays.stream(intervals)
            .map(IntervalHelper::mapIntArrayToInterval)
            .collect(Collectors.toCollection(LinkedList::new));
        LinkedList<IInterval<Integer>> b = new LinkedList<>(Arrays.asList(IntervalHelper.mapIntArrayToInterval(newInterval)));

        List<IInterval<Integer>> result = new LinkedList<>();
        while (!a.isEmpty() || !b.isEmpty()){
            if (a.isEmpty()) {
                result.add(b.pollFirst());
                continue;
            }
            if (b.isEmpty()) {
                result.add(a.pollFirst());
                continue;
            }

            IInterval<Integer> u = a.peekFirst();
            IInterval<Integer> v = b.peekFirst();
            if (IntervalHelper.isClosedIntervalOverlap(u,v)) {
                IInterval<Integer> tmp = IntervalHelper.mergeInterval(u,v);
                a.pollFirst(); b.pollFirst();
                while (!a.isEmpty() && IntervalHelper.isClosedIntervalOverlap(a.peekFirst(), tmp)) {
                    tmp = IntervalHelper.mergeInterval(a.pollFirst(), tmp);
                }
                a.addFirst(tmp);
            }
            else {
                if (u.getRight() < v.getLeft()) result.add(a.pollFirst());
                else result.add(b.pollFirst());
            }
        }
        return result.stream()
            .map(IntervalHelper::mapIntervalToIntArray)
            .toArray(int[][]::new);
    }
}
