package leetcode._24;

import lib.common.Multiset;

public class P2462 {


    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int [] a = new int [ 2 * n];
        for (int i=0;i<a.length;++i) a[i] = costs[i % n];
        int R = n - candidates;
        int L = Math.min(n + candidates - 1, R + n - 1);
        Multiset<Integer> ms = new Multiset<>();
        for (int i=R;i<n;++i) ms.add(a[i] * 2 + 1);
        for (int i=n;i<=L;++i) ms.add(a[i] * 2);
        long result = 0;
        for (int i=0;i<k;++i) {
            int cur = ms.getMin();
            result += cur >> 1;
            ms.remove(cur);
            if (L - R + 1 < n) {
                if ((cur & 1) > 0) {
                    ms.add(a[--R] * 2 + 1);
                }
                else {
                    ms.add(a[++L] * 2);
                }
            }
        }
        return result;
    }



}
