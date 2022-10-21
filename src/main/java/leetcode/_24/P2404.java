package leetcode._24;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class P2404 {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0,0);
        for (int x : nums)
            if ((x & 1) == 0)
                count.put(x, count.getOrDefault(x, 0) + 1);

        int result = -1;
        for (Map.Entry<Integer,Integer> entry : count.entrySet()){
            if (entry.getValue() > count.getOrDefault(result, 0) ||
                (entry.getValue() == count.getOrDefault(result, 0) && entry.getKey() < result)
            ) {
                result = entry.getKey();
            }
        }
        return result;
    }
}
