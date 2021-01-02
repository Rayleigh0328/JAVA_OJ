package leetcode;


import lib.interval.IInterval;
import lib.interval.Interval;
import lib.interval.IntervalHelper;

import java.util.LinkedList;

public class P986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        LinkedList<IInterval> a = convertToList(A);
        LinkedList<IInterval> b = convertToList(B);
        LinkedList<IInterval> result = new LinkedList<>();
        while (!a.isEmpty() && !b.isEmpty()) {
            IInterval int1 = a.getFirst();
            IInterval int2 = b.getFirst();
            IInterval tmp = IntervalHelper.getClosedIntervalIntersection(int1, int2);
            if (tmp != null) result.add(tmp);
            if ((int)int1.getRight() < (int)int2.getRight()) a.pollFirst();
            else b.pollFirst();
        }
        return result.stream().map(interval -> {
            int [] tmp = new int[2];
            tmp[0] = (int) interval.getLeft();
            tmp[1] = (int) interval.getRight();
            return tmp;
        }).toArray(int[][]::new);
    }

    private LinkedList<IInterval> convertToList(int [][] arr){
        LinkedList<IInterval> result = new LinkedList<>();
        for (int[] e : arr) {
            result.add(new Interval(e[0], e[1]));
        }
        return result;
    }
}
