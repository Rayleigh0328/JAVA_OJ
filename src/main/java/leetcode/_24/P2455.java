package leetcode._24;

import java.util.Arrays;
import java.util.OptionalDouble;

public class P2455 {

    public int averageValue(int[] nums) {
        OptionalDouble opt = Arrays.stream(nums).filter(e -> e % 6 == 0).average();
        return (int) Math.floor(opt.orElse(0.0));
    }

}
