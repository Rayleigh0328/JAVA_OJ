package leetcode;

import leetcode._17.P1703;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P1703Test {

    private P1703 underTest = new P1703();

    @Test
    public void sample1(){
        int [] nums = new int [] {1,0,0,1,0,1};
        int k = 2;
        int expectedOutput = 1;
        int result = underTest.minMoves(nums, k);
        assertEquals(expectedOutput, result);
    }

    @Test
    public void sample2(){
        int [] nums = new int [] {1,0,0,0,0,0,1,1};
        int k = 3;
        int expectedOutput = 5;
        int result = underTest.minMoves(nums, k);
        assertEquals(expectedOutput, result);
    }

    @Test
    public void sample3(){
        int [] nums = new int [] {1,1,0,1};
        int k = 2;
        int expectedOutput = 0;
        int result = underTest.minMoves(nums, k);
        assertEquals(expectedOutput, result);
    }
}
