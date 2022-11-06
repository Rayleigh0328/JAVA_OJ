package leetcode._24;

public class P2457 {

    private static int MAX_SIZE = 20;
    private static long [] a = new long [MAX_SIZE];

    public long makeIntegerBeautiful(long n, int target) {
        convert(n);
        long result = 0;
        long base = 1;
        for (int i=0;getTotal() > target;++i, base*=10) {
            if (a[i] == 0) {
                continue;
            }
            result += (10 - a[i]) * base;
            a[i] = 0;
            ++a[i+1];
            maintain(i+1);
        }
        return result;
    }

    private void maintain(int pos) {
        for (int i=pos;i<MAX_SIZE;++i) {
            if (a[i] >= 10) {
                a[i+1] += a[i] / 10;
                a[i] = a[i] % 10;
            }
        }
    }

    private void convert(long x) {
        for (int i=0;i<MAX_SIZE;++i) a[i] = 0;
        for (int i=0;x > 0;++i) {
            a[i] = x % 10;
            x /= 10;
        }
    }

    private int getTotal() {
        int result = 0;
        for (int i=0;i<MAX_SIZE;++i)
            result += a[i];
        return result;
    }

}
