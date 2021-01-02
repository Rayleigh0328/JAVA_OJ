package lib.interval;

public class Interval<T extends Comparable<T>> implements IInterval<T> {

    private T left, right;

    public Interval(T left, T right){
        this.left = left;
        this.right = right;
    }

    @Override
    public T getLeft() {
        return left;
    }

    @Override
    public T getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "[" +left+","+right+ "]";
    }
}
