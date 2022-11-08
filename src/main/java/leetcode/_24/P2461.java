package leetcode._24;

import java.util.HashMap;
import java.util.Map;

public class P2461 {



    public long maximumSubarraySum(int[] a , int k) {
        long sum = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i=0;i<k;++i) {
            sum += a[i];
            count.put(a[i], count.getOrDefault(a[i], 0) + 1);
        }
        long result = count.size() == k ? sum : 0;
        for (int i=k;i<a.length; ++i) {
            Integer toRemove = a[i-k];
            sum -= toRemove;
            count.put(toRemove, count.get(toRemove) - 1);
            if (count.get(toRemove) == 0) count.remove(toRemove);

            Integer toAdd = a[i];
            sum += toAdd;
            count.put(toAdd, count.getOrDefault(toAdd, 0) + 1);

            if (count.size() == k) result = Math.max(result, sum);
        }
        return result;
    }



}
