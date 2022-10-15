package leetcode._24;

public class P2430_1 {
    public int deleteString(String s) {
        int n = s.length();
        int [] f = new int [n];
        for (int i=n-1;i>=0;--i) {
            f[i] = 1;
            for (int len = 1; len <= n; ++len) {
                int j = i + len;
                if (j + len > n) break;
                if (check(s, i, i+len, j, j+len)) {
                    f[i] = Math.max(f[i], 1 + f[j]);
                }
            }
        }
        return f[0];
    }

    private boolean check(String s, int s1, int t1, int s2, int t2) {
        return s.substring(s1, t1).equals(s.substring(s2,t2));
    }
}
