package leetcode._07;

import lib.common.Multiset;
import lib.string.suffix_array.SuffixArray;
import lib.string.suffix_array.SuffixArrayDoublingConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P718 {

    public int findLength(int[] nums1, int[] nums2) {
        int maxValue = 1002;
        List<Integer> list = new ArrayList();
        Map<Integer, Integer> pathMap = new HashMap();

        for (int x : nums1) {
            list.add(x + 1);
            pathMap.put(list.size()-1,0);
        }
        list.add(++maxValue);
        pathMap.put(list.size()-1,-1);
        for (int x : nums2) {
            list.add(x + 1);
            pathMap.put(list.size()-1,1);
        }
        list.add(++maxValue);
        pathMap.put(list.size()-1,-1);

        SuffixArray suffixArray = new SuffixArray(list, new SuffixArrayDoublingConstructor());
        int[] sa = suffixArray.getSa();
        int[] height = suffixArray.getHeight();

        final int n = sa.length;
        final int m = 2;
        int left, right, result;

        Multiset<Integer> pathSet = new Multiset<>();
        Multiset<Integer> lcpSet = new Multiset<>();

        left = 0;
        right = 1;
        pathSet.add(pathMap.get(sa[0]));
        result = 0;
        while (left < n) {
            while (right < n && getPathCount(pathSet) < m) {
                pathSet.add(pathMap.get(sa[right]));
                lcpSet.add(height[right]);
                ++right;
            }

            if (!lcpSet.isEmpty() && m == getPathCount(pathSet)) {
                result = Math.max(result, lcpSet.getMin());
            }

            pathSet.remove(pathMap.get(sa[left]));
            ++left;
            if (left < n) lcpSet.remove(height[left]);
        }

        return result;
    }

    private int getPathCount(Multiset<Integer> ms) {
        int result = ms.uniqueCount();
        if (ms.contains(-1)) --result;
        return result;
    }
}
