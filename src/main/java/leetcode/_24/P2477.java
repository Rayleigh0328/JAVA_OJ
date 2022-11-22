package leetcode._24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P2477 {

    private static class MyType {
        private long headCount;
        private long fuel;
    }

    private double seatLimit;
    private Map<Integer, List<Integer>> g;
    private Set<Integer> visited;

    public long minimumFuelCost(int[][] roads, int seats) {
        g = new HashMap<>();
        for (int i=0;i<=roads.length;++i) g.put(i, new ArrayList<>());
        for (int[] road : roads) {
            int u = road[0], v = road[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        seatLimit = seats;
        visited = new HashSet<>();
        return dfs(0).fuel;
    }

    private MyType dfs(int cur) {
        visited.add(cur);
        MyType result = new MyType();
        result.headCount = 1;
        for (int u : g.get(cur)) {
            if (visited.contains(u)) continue;

            MyType tmp = dfs(u);
            result.headCount += tmp.headCount;
            result.fuel += tmp.fuel;
            result.fuel += tmp.headCount % seatLimit == 0 ?
                tmp.headCount / seatLimit :
                tmp.headCount / seatLimit + 1;
        }
        return result;
    }

}
