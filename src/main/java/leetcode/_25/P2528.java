package leetcode._25;

public class P2528 {

    boolean check(int [] input, int r, int k, long req) {
        long [] a = new long[input.length];
        final int n = a.length;
        for (int i=0;i<n;++i) a[i] = input[i];
        long available = k;

        long windowSum = 0;
        for (int i=0;i<=r;++i) windowSum += a[i];
        long delta;
        for (int i=0;i<n;++i) {
            if (windowSum < req) {
                delta = req - windowSum;
                a[Math.min(n-1, i+r)] += delta;
                windowSum = req;
                available -= delta;
                if (available < 0) return false;
            }
            if (i-r>=0) windowSum -= a[i-r];
            if (i+r+1<n) windowSum += a[i+r+1];
        }
        return true;
    }

    public long maxPower(int[] stations, int r, int k) {
        long L = 0l;
        long R = (1l << 60);
        long M;
        while (L < R) {
            if (L == R-1) {
                return L;
            }
            if (L == R-2) {
                if (check(stations, r, k, L+1)) return L+1;
                return L;
            }
            M = L + ((R - L) >> 1);
            if (check(stations, r, k, M)) L = M;
            else R = M;
        }
        return -1;
    }


}
