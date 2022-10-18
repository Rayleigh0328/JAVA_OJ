package leetcode._24;

public class P2439_2 {
    public int minimizeArrayValue(int[] a) {
        long cur = a[0], gap = 0, rem, delta;
        for (int i=1;i<a.length;++i) {
            if (a[i] <= cur) {
                gap += cur - a[i];
                continue;
            }
            if (gap >= a[i] - cur) {
                gap -= a[i] - cur;
                continue;
            }
            rem = a[i] - cur - gap;
            if (rem % (i+1) == 0) {
                gap = 0;
                cur += rem / (i+1);
            } else {
                delta = rem / (i+1) + 1;
                gap = (i+1) * delta - rem;
                cur += rem / (i+1) + 1;
            }
        }
        return (int) cur;
    }
}
