package leetcode._24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P2453 {
    public int destroyTargets(int[] nums, int space) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> a = new TreeMap<>();
        for (int x : nums) {
            if (!a.containsKey(x % space)) a.put(x % space, new ArrayList<>());
            a.get(x % space).add(x);
        }
        int resultKey = nums[0] % space;
        for (Map.Entry<Integer, List<Integer>> entry : a.entrySet()) {
            if (entry.getValue().size() > a.get(resultKey).size()) {
                resultKey = entry.getKey();
            }
            else if (entry.getValue().size() == a.get(resultKey).size() &&
                entry.getValue().get(0) < a.get(resultKey).get(0)) {
                resultKey = entry.getKey();
            }
        }
        return a.get(resultKey).get(0);
    }
}
