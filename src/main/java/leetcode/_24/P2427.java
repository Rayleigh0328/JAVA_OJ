package leetcode._24;

public class P2427 {
    public int commonFactors(int a, int b) {
        int result = 0;
        for (int i=1;i<=Math.min(a,b);++i)
            if (a % i == 0 && b % i == 0) ++result;
        return result;
    }
}
