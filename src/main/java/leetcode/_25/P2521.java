package leetcode._25;

import java.util.HashSet;
import java.util.Set;

public class P2521 {

    private static final int MAX_SIZE = 1001;
    private static final double EPS = 1e-6;
    private static boolean [] prime = new boolean[MAX_SIZE];

    static {
        for (int i=0;i<MAX_SIZE;++i) prime[i] = true;
        prime[0] = prime[1] = false;
        for (int i=2;i<MAX_SIZE;++i)
            for (int j=2*i;j<MAX_SIZE;j+=i)
                prime[j] = false;
    }

    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int x : nums) s.add(x);
        boolean [] f = new boolean [MAX_SIZE];
        for (int i=0;i<MAX_SIZE;++i) f[i] = false;
        s.forEach(x -> {
            for (int i=1;i<=Math.sqrt(x)+EPS; ++i) {
                if (x % i == 0) {
                    f[i] = true;
                    f[x / i] = true;
                }
            }
        });
        int count = 0;
        for (int i=0;i<MAX_SIZE;++i)
            if (f[i] && prime[i]) ++count;
        return count;
    }


}
