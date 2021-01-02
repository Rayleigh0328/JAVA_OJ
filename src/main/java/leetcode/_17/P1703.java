package leetcode._17;

import lib.array.range_sum.RangeSumCalculator;

import java.util.ArrayList;

public class P1703 {
    public int minMoves(int[] nums, int k) {
        if (k <= 1) return 0;
        ArrayList<Long> a = new ArrayList();
        for (int i=0;i<nums.length;++i)
            if (nums[i] == 1) a.add((long) i);

        final int n = a.size();
        RangeSumCalculator<Long> rsc = new RangeSumCalculator(a);

        Long result = Long.MAX_VALUE;
        int mid;
        for (int i=0;i<n;++i){
            if (i + k - 1 >= n) break;
            mid = (2*i + k-1) / 2;
            if ((k & 1) == 1){
                result = Math.min(result, rsc.getRangeSum(mid+1, i+k-1) - rsc.getRangeSum(i,mid-1) - 2*arithmeticSum(k/2));
            }
            else {
                result = Math.min(result, rsc.getRangeSum(mid+1, i+k-1) - rsc.getRangeSum(i,mid) - arithmeticSum(k/2) - arithmeticSum(k/2 - 1));
            }
        }
        return Math.toIntExact(result);
    }

    private long arithmeticSum(long k){
        return k * (k+1) / 2;
    }
}
