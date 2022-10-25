package leetcode._24;

import java.util.LinkedList;
import java.util.Queue;

public class P2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        Queue<Integer> ql = new LinkedList<>();
        Queue<Integer> qu = new LinkedList<>();
        Queue<Integer> qb = new LinkedList<>();
        for (int i=0;i<n;++i) {
            if (nums[i] == minK) ql.add(i);
            if (nums[i] == maxK) qu.add(i);
            if (nums[i] < minK || nums[i] > maxK) qb.add(i);
        }
        qb.add(n);
        long result = 0;
        for (int i=0;i<n && !ql.isEmpty() && !qu.isEmpty();++i) {
            result += Math.max(0,qb.peek() - Math.max(ql.peek(), qu.peek()));

            while (!ql.isEmpty() && ql.peek() <= i) ql.remove();
            while (!qu.isEmpty() && qu.peek() <= i) qu.remove();
            while (!qb.isEmpty() && qb.peek() <= i) qb.remove();
        }
        return result;
    }
}
