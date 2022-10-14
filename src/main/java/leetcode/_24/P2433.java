package leetcode._24;

public class P2433 {
    /*
    p[0] = a[0]
    p[1] = a[0] ^ a[1]          ==> p[0] + p[1] = a[1]
    p[2] = a[0] ^ a[1] ^ a[2]   ==> p[1] + p[2] = a[2]
     */
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int [] a = new int[n];
        a[0] = pref[0];
        for (int i=1;i<n;++i) a[i] = pref[i-1] ^ pref[i];
        return a;
    }
}
