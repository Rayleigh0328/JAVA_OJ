package leetcode._24;

public class P2443 {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i=num/2;i<=num;++i)
            if (i + reverseDigit(i) == num) return true;
        return false;
    }

    private int reverseDigit(int k) {
        StringBuilder sb = new StringBuilder(Integer.toString(k));
        return Integer.valueOf(sb.reverse().toString());
    }
}
