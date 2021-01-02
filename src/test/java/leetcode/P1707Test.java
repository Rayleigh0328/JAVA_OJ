package leetcode;

import leetcode._17.P1707;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P1707Test {

    private P1707 underTest = new P1707();

    /*
        Input: nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
        Output: [3,3,7]
     */
    @Test
    public void sample1(){
        int [] nums = new int [] {0,1,2,3,4};
        int [][] queries = new int[][] {
            new int [] {3,1},
            new int [] {1,3},
            new int [] {5,6}
        };
        int [] expect = new int [] {3,3,7};
        int [] result = underTest.maximizeXor(nums, queries);
        assertArrayEquals(expect, result);
    }

    /*
        Input: nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
        Output: [15,-1,5]
     */
    @Test
    public void sample2(){
        int [] nums = new int [] {5,2,4,6,6,3};
        int [][] queries = new int[][] {
            new int [] {12,4},
            new int [] {8,1},
            new int [] {6,3}
        };
        int [] expect = new int [] {15,-1,5};
        int [] result = underTest.maximizeXor(nums, queries);
        assertArrayEquals(expect, result);
    }
}
