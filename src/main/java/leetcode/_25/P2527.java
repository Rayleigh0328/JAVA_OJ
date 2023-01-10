package leetcode._25;

public class P2527 {


    public int xorBeauty(int[] a) {
        int result = 0;
        for (long bit = 1; bit < (1<<30); bit = (bit << 1)) {
            int count = 0;
            for (int x : a) if ((x & bit) > 0) ++count;
            if ((count & 1) != 0) result += bit;
        }
        return result;
    }


}
