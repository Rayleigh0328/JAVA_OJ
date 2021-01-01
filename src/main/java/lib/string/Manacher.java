package lib.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  Ray
 *
 * pad the original string st like this
 * aabaa --> ^#a#a#b#a#a#$
 * let
 *      -1 denote #
 *      -2 denote ^
 *      -3 denote $
 *      Given that the string only contains character(unsigned int)
 *
 * a is the padded string with each character converted to integer
 * span[i] is the maximum length of the half-palindrome centered at i (not include position i)
 * span[i] is also the palindrome length in the original array
 *
 * padded string:       ^#a#a#b#a#a#$
 * corresponding span:  0012105012100
 *
 */
public class Manacher {

    private int [] a;
    private int [] span;
    String originalString;

    public Manacher(String originalSt){
        originalString = originalSt;

        a = new int[originalSt.length() * 2 + 3];
        span = new int[originalSt.length() * 2 + 3];
        for (int i=0; i<span.length;++i) span[i] = 0;
        a[0] = -2;
        for (int i = 0; i<originalSt.length(); ++i){
            a[i*2 + 1] = -1;
            a[i*2 + 2] = originalSt.charAt(i);
        }
        a[originalSt.length() * 2 + 1] = -1;
        a[originalSt.length() * 2 + 2] = -3;

        int c = 0;
        int r = 0;
        for (int i=1; i<a.length-1; ++i){
            int iMirror = 2*c - i;
            if (r > i) span[i] = Math.min(r - i, span[iMirror]);
            while (a[ i-span[i]-1 ] == a[ i+span[i]+1 ]) ++span[i];
            if (i + span[i] > r){
                r = i + span[i];
                c = i;
            }
        }
    }

    private Character convertIntegerBackToChar(int x){
        if (x == -1) return '#';
        if (x == -2) return '^';
        if (x == -3) return '$';
        return (char) x;
    }

    public String getPaddedString(){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<a.length;++i) sb.append(convertIntegerBackToChar(a[i]));
        return sb.toString();
    }

    public int[] getPaddedArray(){
        return a;
    }

    public int[] getSpan(){
        return span;
    }

    public int getLongestPalindromeLength(){
        int len = 0;
        for (int i=1; i<span.length; ++i)
            if (span[i] > len) len = span[i];
        return len;
    }

    // return a list of locations in the padded array
    public List getLongestPalindromeLocations(){
        int maxLen = getLongestPalindromeLength();
        List list = new ArrayList<Integer>();
        for (int i=0;i<span.length;++i)
            if (span[i] == maxLen) list.add(i);
        return list;
    }

    public String getLongestPalindrome(int loc){
        return getPalindrome(loc, span[loc]);
    }

    public String getPalindrome(int loc, int length){
        StringBuilder sb = new StringBuilder();
        for (int i=loc - length; i<=loc+length;++i)
            if (a[i] > 0) sb.append((char)a[i]);
        return sb.toString();
    }

    // check if [originalStart,originalEnd] is palindrome
    // originalEnd is inclusive
    public boolean isPalindrome(int originalStart, int originalEnd){
        int start = originalStart * 2 + 2;
        int end = originalEnd * 2 + 2;
        int mid = (start + end) / 2;
        return span[mid] >= end - mid;
    }

    public boolean isOriginalPalindrome(){
        return getLongestPalindromeLength() == originalString.length();
    }
}



