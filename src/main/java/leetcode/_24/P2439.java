package leetcode._24;

import java.util.Arrays;

public class P2439 {

    public int minimizeArrayValue(int[] nums) {
        int L = 0;
        int R = Arrays.stream(nums).max().getAsInt() + 1;
        int M;
        while (true) {
            if (L == R-1) return L;
            if (L == R-2) {
                if (check(nums, L)) return L;
                else return L+1;
            }
            M = L + ((R - L) >> 1);
            if (check(nums,M)) R = M + 1;
            else L = M + 1;
        }
    }

    private boolean check(int[] a, int target) {
        long rem = 0;
        for (int i=a.length-1;i>=0;--i) {
            rem = Math.max(0, a[i] + rem - target);
        }
        return rem == 0;
    }
}
