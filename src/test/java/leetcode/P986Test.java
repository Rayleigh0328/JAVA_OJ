package leetcode;

import leetcode._16.P1697;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P986Test {

    private P986 underTest = new P986();
    /*
        Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
        Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
     */
    @Test
    public void sample1(){
        int[][] a = new int[][] {
            new int [] {0,2},
            new int [] {5,10},
            new int [] {13,23},
            new int [] {24,25}
        };
        int [][] b = new int [][] {
            new int [] {1,5},
            new int [] {8,12},
            new int [] {15,24},
            new int [] {25,26}
        };
        int [][] expected = new int [][] {
            new int [] {1,2},
            new int [] {5,5},
            new int [] {8,10},
            new int [] {15,23},
            new int [] {24,24},
            new int [] {25,25},
        };
        int [][] output = underTest.intervalIntersection(a,b);
        assertArrayEquals(expected,output);
    }

    @Test
    public void sample2(){
        int[][] a = new int[][] {
            new int [] {5,10},
        };
        int [][] b = new int [][] {
            new int [] {1,5},
        };
        int [][] expected = new int [][] {
            new int [] {5,5},
        };
        int [][] output = underTest.intervalIntersection(a,b);
        assertArrayEquals(expected,output);
    }
}
