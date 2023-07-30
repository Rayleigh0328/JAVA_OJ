package leetcode._17;

public class P1712 {
    private static final int MODE = 1_000_000_007;
    public int waysToSplit(int[] nums) {
        final int n = nums.length;
        int[] p = new int[n];
        p[0] = nums[0];
        for (int i=1;i<n;++i) p[i] = p[i-1] + nums[i];
        final int s = p[n-1];

        int x=0, yStart=0, yEnd=0, result = 0;
        while (x < n && yStart < n-1) {
            yStart = Math.max(x+1, yStart);
            while (yStart < n-1 && 2*p[x] > p[yStart]) ++yStart;
            yEnd = Math.max(yEnd, yStart);
            while (yEnd < n-1 && 2*p[yEnd] <= s + p[x]) ++yEnd;
            result += yEnd - yStart;
            result %= MODE;
            ++x;
        }
        return result;
    }
}
