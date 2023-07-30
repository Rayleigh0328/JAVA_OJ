package leetcode;

import leetcode._24.P2463;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P2643Test {

    P2463 underTest = new P2463();

//    [9,11,99,101]
//    [[10,1],[7,1],[14,1],[100,1],[96,1],[103,1]]
//    expected: 6
    @Test
    public void test1() {
        long result = underTest.minimumTotalDistance(
            Arrays.asList(9,11,99,101),
            new int[][]{
                {10,1},{7,1},{14,1},{100,1},{96,1},{103,1}
            });
        assertEquals(6, result);
    }

}
