package leetcode._24;

public class P2430_3 {

    private static final int MAX_SIZE = 4001;
    private static final int [][] h = new int[MAX_SIZE][MAX_SIZE];
    private static final int [] f = new int[MAX_SIZE];

    public int deleteString(String s) {

        int n = s.length();

        for (int i=n-1;i>=0;--i)
            for (int j=n-1;j>=0;--j)
                if (s.charAt(i) == s.charAt(j)) {
                    h[i][j] = h[i+1][j+1] + 1;
                }

        for (int i=n-1;i>=0;--i) {
            f[i] = 1;
            for (int len = 1; len <= n; ++len) {
                int j = i + len;
                if (j + len > n) break;
                if (h[i][j] >= len) {
                    f[i] = Math.max(f[i], 1 + f[j]);
                }
            }
        }
        return f[0];
    }
}
