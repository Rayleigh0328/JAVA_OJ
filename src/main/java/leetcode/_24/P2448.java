package leetcode._24;

import java.util.Arrays;

public class P2448 {

    private final class MyType implements Comparable<MyType> {
        long value;
        long weight;

        public MyType(long value, long weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public int compareTo(MyType o) {
            return Long.compare(this.value, o.value);
        }
    }

    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        MyType [] a = new MyType[n];
        for (int i=0;i<n;++i) {
            a[i] = new MyType(nums[i], cost[i]);
        }
        Arrays.sort(a);

        long [] weightSum = new long [n];
        weightSum[0] = a[0].weight;
        for (int i=1;i<n;++i) weightSum[i] = weightSum[i-1] + a[i].weight;

        long [] productSum = new long [n];
        productSum[0] = a[0].value * a[0].weight;
        for (int i=1;i<n;++i) productSum[i] = productSum[i-1] + a[i].value * a[i].weight ;

        long result = Long.MAX_VALUE;
        long cur;
        for (int i=0;i<n;++i) {
            cur = a[i].value * getRangeSum(weightSum, 0, i);
            cur -= getRangeSum(productSum, 0, i);
            cur += getRangeSum(productSum, i+1, n-1);
            cur -= a[i].value * getRangeSum(weightSum, i+1, n-1);
            result = Math.min(result, cur);
        }
        return result;
    }

    long getRangeSum(long [] sum, int from, int to) {
        if (from == 0) return sum[to];
        else return sum[to] - sum[from-1];
    }
}
