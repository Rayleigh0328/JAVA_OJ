package leetcode;

import leetcode._24.P2449;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P2449Test {
    private P2449 underTest = new P2449();
    @Test
    public void test1() {
        assertEquals(
            2,
            underTest.makeSimilar(new int[] {8,12,6}, new int [] {2,14,10})
        );
    }
}
