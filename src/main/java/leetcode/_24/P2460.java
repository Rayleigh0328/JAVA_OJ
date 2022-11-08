package leetcode._24;

import java.util.ArrayList;

public class P2460 {

    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i=0;i<n-1;++i)
            if (nums[i] == nums[i+1]) {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<n;++i)
            if (nums[i] != 0) list.add(nums[i]);
        while (list.size() < n) list.add(0);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
