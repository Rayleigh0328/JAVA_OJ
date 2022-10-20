package leetcode._13;

import lib.string.KMP;

public class P1392 {
    public String longestPrefix(String s) {
        KMP kmp = new KMP(s);
        int index = kmp.getPhi()[s.length()-1];
        if (index== -1) return "";
        else return s.substring(0, index+1);
    }
}
