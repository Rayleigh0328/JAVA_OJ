package lib.interval;

import lib.ArithmeticHelper;

public class IntervalHelper {
    public static <T extends Comparable<T>> boolean isOpenIntervalOverlap(IInterval<T> a, IInterval<T> b){
        return getOpenIntervalIntersection(a,b) != null;
    }

    public static <T extends Comparable<T>> boolean isClosedIntervalOverlap(IInterval<T> a, IInterval<T> b){
        return getClosedIntervalIntersection(a,b) != null;
    }

    public static <T extends Comparable<T>> IInterval<T> getOpenIntervalIntersection(IInterval<T> a, IInterval<T> b){
        T l = ArithmeticHelper.max(b.getLeft(), b.getLeft());
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
}
