package leetcode._24;

public class P2430_2 {
    private static final int p = 31;
    private static final int m = 1_000_000_000 + 9;

    private static final long [][] h = new long [4001][4001];
    private static final long [] b = new long [4001];
    private static final int [] f = new int [4001];

    public int deleteString(String s) {
        int n = s.length();
        for (int i=0;i<n;++i) f[i] = 1;

        b[0] = 1;
        for (int len=1;len<=n;++len) {

            // init rolling hash
            h[len][0] = h[len-1][0] * p + s.charAt(len-1)-'a';
            h[len][0] %= m;

            b[len] = b[len-1] * p % m;
            for (int i=1;i<n;++i) {
                if (i+len-1 >= n) break;
                h[len][i] = h[len][i-1] * p + s.charAt(i+len-1) - 'a' - (b[len] * (s.charAt(i-1) - 'a')) % m + m;
                h[len][i] %= m;
            }
        }

        for (int i=n-1;i>=0;--i) {
            f[i] = 1;
            for (int len = 1; len <= n; ++len) {
                int j = i + len;
                if (j + len > n) break;
                if (h[len][i] == h[len][j]) {
                    f[i] = Math.max(f[i], 1 + f[j]);
                }
            }
        }
        return f[0];
    }
}
