package leetcode;

import leetcode._24.P2444;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P2444Test {
    private P2444 underTest = new P2444();

    @Test
    public void test1() {
        assertEquals(
            118,
            underTest.countSubarrays(
                new int[] {934372,927845,479424,49441,17167,17167,65553,927845,17167,927845,17167,425106,17167,927845,17167,927845,251338,17167},
                17167,
                927845)
        );
    }

    @Test
    public void test2() {
        assertEquals(
            10,
            underTest.countSubarrays(
                new int[] {1,1,1,1,},
                1,
                1)
        );
    }
}
