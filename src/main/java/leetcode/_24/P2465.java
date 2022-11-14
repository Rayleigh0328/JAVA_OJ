package leetcode._24;

import java.util.ArrayList;
import java.util.Arrays;

public class P2465 {


    public int distinctAverages(int[] a) {
        Arrays.sort(a);
        int L = 0, R = a.length-1;
        ArrayList totals = new ArrayList();
        while (L < R) {
            totals.add(a[L++] + a[R--]);
        }
        return (int) totals.stream().distinct().count();
    }



}
