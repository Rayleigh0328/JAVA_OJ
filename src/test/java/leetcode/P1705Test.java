package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P1705Test {

    private P1705_2 underTest = new P1705_2();

    @Test
    public void sample1(){
        int [] apples = new int [] {1,2,3,5,2};
        int [] days = new int [] {3,2,1,4,2};
        int expected = 7;
        int output = underTest.eatenApples(apples, days);
        assertEquals(expected, output);
    }

    @Test
    public void sample2(){
        int [] apples = new int [] {1,2,3,5,2};
        int [] days = new int [] {0,0,0,0,0};
        int expected = 0;
        int output = underTest.eatenApples(apples, days);
        assertEquals(expected, output);
    }

    @Test
    public void sample3(){
        int [] apples = new int [] {1,10,17,10,12,6,20,8,8,22,14,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,5,2,1,0,0,0,0,0,0,23};
        int [] days = new int [] {19999,11,18,22,5,2,14,5,20,7,17,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,2,1,4,2,7,0,0,0,0,0,0,1};
        int expected = 37;
        int output = underTest.eatenApples(apples, days);
        assertEquals(expected, output);
    }
}
