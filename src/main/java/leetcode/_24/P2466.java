package leetcode._24;

public class P2466 {


    private static final long MODE = 1_000_000_007;

    public int countGoodStrings(int low, int high, int x, int y) {
        long [] f = new long [high+1];
        f[0] = 1;
        for (int i=1;i<=high;++i) {
            f[i] = (i-x>=0?f[i-x]:0) + (i-y>=0?f[i-y]:0);
            f[i] %= MODE;
        }
        long result = 0;
        for (int i=low;i<=high;++i)
            result = (result + f[i]) % MODE;
        return (int) result;
    }


}
