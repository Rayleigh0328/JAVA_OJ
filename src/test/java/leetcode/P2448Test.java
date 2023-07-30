package leetcode;

import leetcode._24.P2448;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P2448Test {

    private P2448 underTest = new P2448();

    @Test
    public void test1() {
        assertEquals(
            8,
            underTest.minCost(new int[] {1,3,5,2}, new int [] {2,3,1,14})
        );
    }
}
