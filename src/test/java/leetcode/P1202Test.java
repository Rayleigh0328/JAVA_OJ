package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P1202Test {

    private P1202 underTest = new P1202();

    /*
        Input: s = "dcab", pairs = [[0,3],[1,2]]
        Output: "bacd"
     */
    @Test
    public void sample1(){
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<List<Integer>>();
        pairs.add(Arrays.asList(0,3));
        pairs.add(Arrays.asList(1,2));
        assertEquals("bacd", underTest.smallestStringWithSwaps(s, pairs));
    }

    /*
        Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
        Output: "abcd"
     */
    @Test
    public void sample2(){
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<List<Integer>>();
        pairs.add(Arrays.asList(0,3));
        pairs.add(Arrays.asList(1,2));
        pairs.add(Arrays.asList(0,2));
        assertEquals("abcd", underTest.smallestStringWithSwaps(s, pairs));
    }

    /*
        Input: s = "cba", pairs = [[0,1],[1,2]]
        Output: "abc"
     */
    @Test
    public void sample3(){
        String s = "cba";
        List<List<Integer>> pairs = new ArrayList<List<Integer>>();
        pairs.add(Arrays.asList(1,2));
        pairs.add(Arrays.asList(0,1));
        assertEquals("abc", underTest.smallestStringWithSwaps(s, pairs));
    }
}
