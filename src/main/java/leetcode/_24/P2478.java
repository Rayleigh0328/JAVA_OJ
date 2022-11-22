package leetcode._24;

public class P2478 {


    private static final int MODE = 1_000_000_007;

    public int beautifulPartitions(String str, int target, int minLength) {
        char [] s = str.toCharArray();
        int n = s.length;

        if (!isPrime(s[0])) return 0;

        long [][] f = new long [target+1][n];
        for (int i=minLength-1;i<n;++i)
            f[1][i] = isPrime(s[i]) ? 0 : 1;

        for (int j=2;j<=target;++j) {
            int cur = 1;
            long sum = 0;
            for (int i=0;i<n;++i) {
                if (isPrime(s[i])) continue;
                while (i - cur + 1>= minLength) {
                    if (isPrime(s[cur])) { sum += f[j-1][cur-1]; sum %= MODE; }
                    ++cur;
                }
                f[j][i] = sum;
            }
        }

        return (int) f[target][n-1];
    }

    private boolean isPrime(char c) {
        return c == '2' || c == '3' || c == '5' || c == '7';
    }

}
