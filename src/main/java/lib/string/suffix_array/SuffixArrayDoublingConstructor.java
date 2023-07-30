package lib.string.suffix_array;

import java.util.Map;
import java.util.TreeMap;

public class SuffixArrayDoublingConstructor implements SuffixArrayConstructor{

    @Override
    public int[] buildRank(int[] a) {
        assert a[a.length - 1] == -1;
        int base = a.length;
        // create rank of length 1
        Map<Long, Integer> rankMap = new TreeMap<>();
        for (int i=0; i<base;++i) rankMap.put(0l + a[i], 0);
        int count = 0;
        for (Long x : rankMap.keySet()) rankMap.put(x, count++);
        int [] rank = new int [base];
        for (int i=0;i<base;++i) rank[i] = rankMap.get(0l + a[i]);
        // loop from length 2^1, 2^2...
        for (int len=1; len<base; len *=2){
            rankMap.clear();
            for (int l = 0; l < base; ++l) rankMap.put(getCombinedRank(rank, len, l), 0);
            count = 0;
            for (Long x : rankMap.keySet()) rankMap.put(x, count++);
            for (int l=0;l<base;++l) rank[l] = rankMap.get(getCombinedRank(rank,len,l));
            if (rankMap.keySet().size() == base) break;
        }

        return rank;
    }

    private long getCombinedRank(int[] array, int dist, int left){
        int right = left + dist;
        long x = new Long(array[left]);
        long y = new Long(right < array.length ? array[right]:0);
        if (right >= array.length) return x * array.length;
        else return x * array.length + y;
    }

    @Override
    public int[] buildSaFromRank(int[] rank) {
        int[] sa = new int [rank.length];
        for (int i=0; i<rank.length; ++i) sa[rank[i]] = i;
        return sa;
    }
}