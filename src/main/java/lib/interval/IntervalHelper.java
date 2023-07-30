package lib.interval;

import lib.common.ArithmeticHelper;

public class IntervalHelper {
    public static <T extends Comparable<T>> boolean isOpenIntervalOverlap(IInterval<T> a, IInterval<T> b){
        return getOpenIntervalIntersection(a,b) != null;
    }

    public static <T extends Comparable<T>> boolean isClosedIntervalOverlap(IInterval<T> a, IInterval<T> b){
        return getClosedIntervalIntersection(a,b) != null;
    }

    public static <T extends Comparable<T>> IInterval<T> getOpenIntervalIntersection(IInterval<T> a, IInterval<T> b){
        T l = ArithmeticHelper.max(a.getLeft(), b.getLeft());
        T r = ArithmeticHelper.min(a.getRight(), b.getRight());
        if (l.compareTo(r) < 0) return new Interval<>(l,r);
        return null;
    }

    public static <T extends Comparable<T>> IInterval<T> getClosedIntervalIntersection(IInterval<T> a, IInterval<T> b){
        T l = ArithmeticHelper.max(a.getLeft(), b.getLeft());
        T r = ArithmeticHelper.min(a.getRight(), b.getRight());
        if (l.compareTo(r) <= 0) return new Interval<>(l,r);
        return null;
    }

    public static <T extends Comparable<T>> IInterval<T> mergeInterval(IInterval<T> a, IInterval<T> b){
        T l = ArithmeticHelper.min(a.getLeft(), b.getLeft());
        T r = ArithmeticHelper.max(a.getRight(), b.getRight());
        return new Interval<>(l,r);
    }

    public static <T extends Comparable<T>> boolean onLeft(IInterval<T> x, IInterval<T> y) {
        return x.getRight().compareTo(y.getLeft()) < 0;
    }

    public static <T extends Comparable<T>> boolean onRight(IInterval<T> x, IInterval<T> y) {
        return x.getLeft().compareTo(y.getRight()) > 0;
    }

    public static IInterval<Integer> mapIntArrayToInterval(int[] a){
        return new Interval(a[0], a[1]);
    }

    public static int[] mapIntervalToIntArray(IInterval<Integer> interval){
        int [] result = new int [2];
        result[0] = interval.getLeft();
        result[1] = interval.getRight();
        return result;
    }
}
