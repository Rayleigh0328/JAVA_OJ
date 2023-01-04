package leetcode._24;

public class P2481 {


    public int numberOfCuts(int n) {
        if (n == 1) return 0;
        if (n % 2 == 0) return n/2;
        return n;
    }


}
