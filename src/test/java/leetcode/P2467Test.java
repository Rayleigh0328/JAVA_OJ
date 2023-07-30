package leetcode;

import leetcode._24.P2467;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P2467Test {

    P2467 underTest = new P2467();

    /*
    [[0,1],[1,2],[1,3],[3,4]]
    3
    [-2,4,2,-4,6]
     */

    @Test
    public void test1() {
        int result = underTest.mostProfitablePath(
            new int[][] {
                new int [] {0,1},
                new int [] {1,2},
                new int [] {1,3},
                new int [] {3,4},
            },
            3,
            new int [] {-2,4,2,-4,6}
        );

        assertEquals(6, result);
    }

    @Test
    public void test2() {
        int result = underTest.mostProfitablePath(
            new int[][] {
                new int [] {0,1},
            },
            1,
            new int [] {-7280,2350}
        );

        assertEquals(-7280, result);
    }
}
