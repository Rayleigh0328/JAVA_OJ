package leetcode._24;

import lib.common.ArithmeticHelper;

import java.util.ArrayList;

public class P2438 {

    private static final int MAX_SIZE = 3000;
    private static final int mode = 1_000_000_000 + 7;
    private static final int h[] = new int [MAX_SIZE];

    static {
        h[0] = 1;
        for (int i=1;i<MAX_SIZE;++i) {
            h[i] = 2 * h[i-1];
            h[i] %= mode;
        }
    }

    public int[] productQueries(int n, int[][] queries) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i=0;i<30;++i)
            if ((n & (1<<i)) > 0) a.add(i);
        int k = a.size();
        int [] s = new int[k];
        s[0] = a.get(0);
        for (int i=1;i<k;++i)
            s[i] = s[i-1] + a.get(i);
        ArrayList<Integer> result = new ArrayList<>();
        int from, to, pow;
        for (int[] query : queries) {
            from = query[0];
            to = query[1];
            pow = s[to];
            if (from > 0) pow -= s[from-1];
            result.add(h[pow]);
        }
        return result.stream().mapToInt(e -> e).toArray();
    }
}
