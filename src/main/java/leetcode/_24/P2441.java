package leetcode._24;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class P2441 {
    public int findMaxK(int[] nums) {
        Set<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int result = -1;
        for (Integer x : nums) {
            if (s.contains(-x)) result = Math.max(result, x);
        }
        return result;
    }
}
