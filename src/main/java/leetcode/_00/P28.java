package leetcode._00;

import lib.string.KMP;

public class P28 {
    public int strStr(String haystack, String needle) {
        KMP kmp = new KMP(needle);
        int[] a = kmp.match(haystack);
        for (int i=0;i<a.length;++i)
            if (a[i]==needle.length()-1) return i-needle.length()+1;
        return -1;
    }
}
