package leetcode._16;

import java.util.HashMap;

public class P1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> mp = new HashMap();
        for (int i=0;i<arr.length;++i) mp.put(arr[i], i);
        for (int[] piece : pieces){
            if (mp.get(piece[0]) == null) return false;
            for (int i=1;i<piece.length;++i)
                if (mp.get(piece[i]) == null || mp.get(piece[i]) != mp.get(piece[i-1]) + 1) return false;
        }
        return true;
    }
}
