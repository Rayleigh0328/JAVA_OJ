package lib.interval;

public interface IInterval<E extends Comparable<E>> {
    E getLeft();
    E getRight();
}
