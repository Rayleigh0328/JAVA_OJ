package leetcode;

import leetcode._25.P2518;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P2518Test {

    P2518 underTest = new P2518();

    @Test
    public void test1() {
        long result = underTest.countPartitions(
            new int[] {6,6},
            2
        );
        assertEquals(2, result);
    }

    @Test
    public void test2() {
        long result = underTest.countPartitions(
            new int[] {1,2,3,4},
            4
        );
        assertEquals(6, result);
    }

    @Test
    public void test3() {
        long result = underTest.countPartitions(
            new int[] {3,3,3},
            4
        );
        assertEquals(0, result);
    }

    @Test
    public void test4() {
        long result = underTest.countPartitions(
            new int[] {96,40,22,98,9,97,45,22,79,57,95,62},
            505
        );
        assertEquals(0, result);
    }

    @Test
    public void test5() {
        long result = underTest.countPartitions(
            new int[] {1, 2},
           100
        );
        assertEquals(0, result);
    }

    @Test
    public void test6() {
        long result = underTest.countPartitions(
            new int[] {452712990,304923574,514804081,516542653,302633600,387844856,254193892,514125672,231231273,537828972,739788846,997137192,323638612,980131474,932473011,451725510,603721810,314059822,812497197,880888575,270244953,703545293,853537357,744164576,92185020,481926703,917558408,760008715,101971293},
            778
        );
        assertEquals(536870910, result);
    }

}
