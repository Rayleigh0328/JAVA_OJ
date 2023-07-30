package leetcode;

import lib.string.Manacher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class P5666Test {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        System.out.println(n);
        Manacher manacher = new Manacher(s);
        for (int i=1;i<n;++i)
            for (int j=i+1;j<n;++j)
                if (manacher.isPalindrome(0,i-1) && manacher.isPalindrome(i,j-1) && manacher.isPalindrome(j,n-1)){
                    return true;
                }
        return false;
    }

    @Test
    public void test1(){
        assertTrue(checkPartitioning("abc"));
    }
}
