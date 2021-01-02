package leetcode;

import leetcode._00.P57;
import leetcode._00.P57_2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P57Test {
    private P57_2 underTest = new P57_2();

    /*
        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
        Output: [[1,5],[6,9]]
     */
    @Test
    public void sample1(){
        int[][] a = new int[][] {
            new int [] {1,3},
            new int [] {6,9}
        };
        int [] b = new int [] {2,5};

        int [][] expected = new int [][] {
            new int [] {1,5},
            new int [] {6,9}
        };
        int [][] output = underTest.insert(a,b);
        assertArrayEquals(expected,output);
    }

    /*
        [[1,2],[3,5],[6,7],[8,10],[12,16]]
        [4,8]

        [[1,2],[3,10],[12,16]]
     */
    @Test
    public void sample2(){
        int[][] a = new int[][] {
            new int [] {1,2},
            new int [] {3,5},
            new int [] {6,7},
            new int [] {8,10},
            new int [] {12,16},
        };
        int [] b = new int [] {4,8};

        int [][] expected = new int [][] {
            new int [] {1,2},
            new int [] {3,10},
            new int [] {12,16}
        };
        int [][] output = underTest.insert(a,b);
        assertArrayEquals(expected,output);
    }

    /*
        [[1,5]]
        [0,0]

        [[0,0],[1,5]]
     */
    @Test
    public void sample3(){
        int[][] a = new int[][] {
            new int [] {1,5},
        };
        int [] b = new int [] {0,0};

        int [][] expected = new int [][] {
            new int [] {0,0},
            new int [] {1,5},
        };
        int [][] output = underTest.insert(a,b);
        assertArrayEquals(expected,output);
    }
}
