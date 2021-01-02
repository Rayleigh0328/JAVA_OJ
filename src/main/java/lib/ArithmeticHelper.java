package lib;

public class ArithmeticHelper {

    public static <T extends Number> Number add(T x, T y) {
        if (x instanceof Integer){
            return x.intValue() + y.intValue();
        }
        else if (x instanceof Long) {
            return x.longValue() + y.longValue();
        }
        else if (x instanceof Double) {
            return x.doubleValue() + y.doubleValue();
        }
        else {
            throw new RuntimeException("Invalid type " + x.getClass().getSimpleName());
        }
    }

    public static <T extends Number> Number subtract(T x, T y) {
        if (x instanceof Integer){
            return x.intValue() - y.intValue();
        }
        else if (x instanceof Long) {
            return x.longValue() - y.longValue();
        }
        else if (x instanceof Double) {
            return x.doubleValue() - y.doubleValue();
        }
        else {
            throw new RuntimeException("Invalid type " + x.getClass().getSimpleName());
        }
    }

    public static <T extends Comparable<T>> T min(T x, T y){
        if (x.compareTo(y) < 0) return x;
        else return y;
    }

    public static <T extends Comparable<T>> T max(T x, T y){
        if (x.compareTo(y) > 0) return x;
        return y;
    }
}
