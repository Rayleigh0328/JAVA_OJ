package leetcode._25;

import java.util.Arrays;

public class P2518 {

    private static final long MODE = 1_000_000_007;

    public int countPartitions(int[] a, int k) {
        final int n = a.length;
        long [] f = new long [k];
        for (int i=0;i<k;++i) f[i] = 0;
        f[0] = 1;

        for (int x : a) {
            for (int i=k-1;i>=x;--i) {
                f[i] += f[i-x];
                f[i] %= MODE;
            }
        }

        long sum = 0;
        for (int i=0;i<n;++i) sum += a[i];
        long ans = 1;
        for (int i=0;i<n;++i) { ans *= 2; ans %= MODE; }
        for (int i=0;i<k;++i) {
            ans += 2 * MODE;
            if (sum-i >= k) ans-= 2 * f[i];
            else ans -= f[i];
            ans %= MODE;
        }
        return (int) ans;
    }


}
