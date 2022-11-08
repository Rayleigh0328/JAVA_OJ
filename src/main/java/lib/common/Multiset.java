package lib.common;

import java.util.Map;
import java.util.TreeMap;

public class Multiset<T extends Comparable<T>> {

    private TreeMap<T, Integer> count = new TreeMap<>();
    private int size = 0;

    public Multiset() {

    }

    public int size() {
       return size;
    }

    public int uniqueCount() {
        return count.size();
    }

    public void add(T key) {
        if (key == null) return;
        Integer tmp = count.get(key);
        if (tmp == null) {
            count.put(key, 1);
        }
        else {
            count.put(key, tmp + 1);
        }
        ++size;
    }

    public void remove(T key) {
        if (key == null) return;
        Integer tmp = count.get(key);
        if (tmp == null) return;
        if (tmp <= 1) {
            count.remove(key);
        }
        else {
            count.put(key, tmp - 1);
        }
        --size;
    }

    public void removeAll(T key) {
        if (key == null) return;
        Integer tmp = count.get(key);
        if (tmp == null) tmp = 0;
        count.remove(key);
        size -= tmp;
    }

    public void clear() {
        count.clear();
        size = 0;
    }

    public T getMin() {
        if (count.isEmpty()) return null;
        return count.firstEntry().getKey();
    }

    public T getMax() {
        if (count.isEmpty()) return null;
        return count.lastEntry().getKey();
    }

    public boolean contains(T key) {
        if (key == null) return false;
        Integer tmp = count.get(key);
        return (tmp != null && tmp > 0);
    }

    public boolean isEmpty() {
        return count.isEmpty();
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuffer sb = new StringBuffer();
        sb.append('[');
        for (Map.Entry<T, Integer> entry : count.entrySet()) {
            for (int i=0;i<entry.getValue();++i) {
                sb.append(entry.getKey().toString());
                sb.append(',');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }
}
