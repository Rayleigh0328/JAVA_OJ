package leetcode._24;

public class P2439_2 {
    public int minimizeArrayValue(int[] a) {
        int result = -1;
        double total = 0;
        for (int i=0;i<a.length;++i) {
            total += a[i];
            result = Math.max(result, (int) Math.ceil(total / (i+1)));
        }
        return result;
    }
}
