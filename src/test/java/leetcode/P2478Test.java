package leetcode;

import leetcode._24.P2478;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P2478Test {

    private P2478 underTest = new P2478();

    @Test
    public void test1() {
        int result = underTest.beautifulPartitions(
            "23542185131",
            3,
            2
        );
        assertEquals(3, result);
    }

    @Test
    public void test2() {
        int result = underTest.beautifulPartitions(
            "783938233588472343879134266968",
            4,
            6
        );
        assertEquals(4, result);
    }

}
