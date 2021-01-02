package leetcode;

import java.util.Optional;
import java.util.TreeMap;

public class P1705 {
    public int eatenApples(int[] apples, int[] days) {
        int result = 0;
        TreeMap<Integer, Integer> mp = new TreeMap();
        for (int i=0;i<apples.length;++i){
            Integer tmp = Optional.ofNullable(mp.get(i + days[i])).orElse(0);
            mp.put(i + days[i], apples[i] + tmp);
            result += tryToEat(i, mp);
        }

        int cur = apples.length;
        while (!mp.isEmpty()){
            result += tryToEat(cur, mp);
            ++cur;
        }

        return result;
    }

    private int tryToEat(int day, TreeMap<Integer, Integer> mp){
        while (!mp.isEmpty() && (mp.firstEntry().getKey() <= day || mp.firstEntry().getValue() == 0))
            mp.remove(mp.firstKey());
        if (mp.isEmpty()) return 0;
        mp.replace(mp.firstKey(), mp.firstEntry().getValue() - 1);
        return 1;
    }
}
