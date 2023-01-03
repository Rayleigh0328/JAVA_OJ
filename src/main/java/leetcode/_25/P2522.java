package leetcode._25;

public class P2522 {

    private static final int INF = (1<<30);
    private static final int MAX_LEN = 9;

    private boolean compare(String str, int s, int t, long k) {
        if (s < 0) return false;
        return Long.valueOf(str.substring(s,t+1)) <= k;
    }

    public int minimumPartition(String s, int k) {
        final int n = s.length();
        int [] f = new int[n];
        for (int i=0;i<n;++i) f[i] = INF;

        for (int i=0;i<n;++i) {
            for (int j=1;j<=MAX_LEN;++j)
                if (compare(s,i-j+1,i,k)) {
                    f[i] = Math.min(f[i], (i-j>=0?f[i-j]:0) + 1);
                }
                else {
                    break;
                }
        }

        return f[n-1] == INF ? -1 : f[n-1];
    }

}
