package leetcode._24;

public class P2447 {
    public int subarrayGCD(int[] a, int k) {
        int n = a.length;
        int [][] f = new int[n][n];
        int result = 0;
        for (int i=0;i<n;++i) {
            f[i][i] = a[i];
            for (int j=i+1;j<n;++j) {
                f[i][j] = gcd(f[i][j-1], a[j]);
            }
        }
        for (int i=0;i<n;++i) {
            for (int j=i;j<n;++j) {
                if (f[i][j] == k) ++result;
            }
        }
        return result;
    }

    private int gcd(int n, int m) {
        if (n % m == 0) return m;
        else return gcd(m, n % m);
    }
}
