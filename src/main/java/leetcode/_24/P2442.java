package leetcode._24;

import java.util.HashSet;
import java.util.Set;

public class P2442 {
    public int countDistinctIntegers(int[] a) {
        Set<Integer> s = new HashSet<>();
        for (int i=0;i<a.length;++i) {
            s.add(a[i]);
            s.add(reverseDigit(a[i]));
        }
        return s.size();
    }

    private int reverseDigit(int k) {
        StringBuilder sb = new StringBuilder(Integer.toString(k));
        return Integer.valueOf(sb.reverse().toString());
    }
}
