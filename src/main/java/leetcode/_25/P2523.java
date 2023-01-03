package leetcode._25;

import java.util.ArrayList;

public class P2523 {

    private static final int MAX_SIZE = 1000000;

    static ArrayList<Integer> a = new ArrayList<>();

    static {
        boolean b[] = new boolean[MAX_SIZE];
        b[0] = b[1] = false;
        for (int i=2;i<MAX_SIZE;++i) b[i] = true;
        for (int i=2;i<MAX_SIZE;++i)
            for (int j=i*2; j<MAX_SIZE; j+=i)
                b[j] = false;
        for (int i=2;i<MAX_SIZE;++i)
            if (b[i]) a.add(i);
    }

    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for (Integer x : a)
            if (left <= x && x <= right) tmp.add(x);
        int ans = -1;
        for (int i=1;i<tmp.size();++i) {
            if (ans == -1) ans = i;
            else if (tmp.get(ans) - tmp.get(ans-1) > tmp.get(i) - tmp.get(i-1)) ans = i;
        }
        if (ans == -1) return new int [] {-1,-1};
        return new int [] {tmp.get(ans-1), tmp.get(ans)};
    }

}
