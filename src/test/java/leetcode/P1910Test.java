package leetcode;

import leetcode._19.P1910;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P1910Test {
    private P1910 underTest = new P1910();

    @Test
    public void test1() {
        assertEquals(
            "dab",
            underTest.removeOccurrences("daabcbaabcbc", "abc")
        );
    }

    @Test
    public void test2() {
        assertEquals(
            "ab",
            underTest.removeOccurrences("axxxxyyyyb", "xy")
        );
    }
}
