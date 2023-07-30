package leetcode;

import leetcode._17.P1782;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P1782Test {
    P1782 underTest = new P1782();

    @Test
    public void sample1() {
        int n = 4;
        int[][] edges = new int[][]{
            new int[]{1, 2},
            new int[]{2, 4},
            new int[]{1, 3},
            new int[]{2, 3},
            new int[]{2, 1}
        };
        int[] queries = new int[]{3};
        int[] expect = new int[]{5};
        int[] result = underTest.countPairs(n, edges, queries);
        assertArrayEquals(expect, result);
    }

    @Test
    public void sample2() {
        int n = 5;
        int[][] edges = new int[][]{
            new int[]{1, 5},
            new int[]{1, 5},
            new int[]{3, 4},
            new int[]{2, 5},
            new int[]{1, 3},
            new int[]{5, 1},
            new int[]{2, 3},
            new int[]{2, 5}
        };
        int[] queries = new int[]{1, 2, 3, 4, 5};
        int[] expect = new int[]{10, 10, 9, 8, 6};
        int[] result = underTest.countPairs(n, edges, queries);
        assertArrayEquals(expect, result);
    }

    /*
    5
    [[4,5],[1,3],[1,4]]
    [0,1,0,0,1,1,0,0,0,0,1,0,0,1,0,1,1,2]

    [10,8,10,10,8,8,10,10,10,10,8,10,10,8,10,8,8,3]
     */
    @Test
    public void sample3() {
        int n = 5;
        int[][] edges = new int[][]{
            new int[]{4, 5},
            new int[]{1, 3},
            new int[]{1, 4}
        };
        int[] queries = new int[]{0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 2};
        int[] expect = new int[]{10, 8, 10, 10, 8, 8, 10, 10, 10, 10, 8, 10, 10, 8, 10, 8, 8, 3};
        int[] result = underTest.countPairs(n, edges, queries);
        assertArrayEquals(expect, result);

    }

    /*
    10
    [[6,4],[10,1],[10,1],[8,10]]
    [0,0,0,1,0,0,0,0,0,0,1,0,2,1,1,0,0,0,0]
     */
    @Test
    public void sample4() {
        int n = 10;
        int[][] edges = new int[][]{
            new int[]{6,4},
            new int[]{10,1},
            new int[]{10,1},
            new int[]{8,10}
        };
        int[] queries = new int[]{0,0,0,1,0,0,0,0,0,0,1,0,2,1,1,0,0,0,0};
        int[] expect = new int[]{35,35,35,19,35,35,35,35,35,35,19,35,12,19,19,35,35,35,35};
        int[] result = underTest.countPairs(n, edges, queries);
        assertArrayEquals(expect, result);

    }
}
