package leetcode._17;

import lib.tree.RbTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class P1782 {

    private int n;
    private int [] deg;
    private Map<Integer, Map<Integer, Integer>> E;
    private RbTree<Integer> rbTree;

    private void insert(int u, int v) {
        ++deg[u];
        E.get(u).put(v, Optional.ofNullable(E.get(u).get(v)).orElse(0) + 1);
    }

    private int solve(int limit) {
        int result = 0;
        int u,v, cnt;
        for (Map.Entry<Integer, Map<Integer, Integer>> entry1 : E.entrySet()) {
            u = entry1.getKey();
            for (Map.Entry<Integer, Integer> entry2 : entry1.getValue().entrySet()) {
                v = entry2.getKey();
                cnt = entry2.getValue();
                if (deg[u] + deg[v] - cnt > limit) ++result;
                rbTree.erase(deg[v]);
            }
            rbTree.erase(deg[u]);

            result += rbTree.countGreater(limit - deg[u]);

            for (Map.Entry<Integer, Integer> entry2 : entry1.getValue().entrySet()) {
                v = entry2.getKey();
                rbTree.insert(deg[v]);
            }
            rbTree.insert(deg[u]);
        }
        return result / 2;
    }

    public int[] countPairs(int nn, int[][] edges, int[] queries) {
        n = nn;
        E = new HashMap<>();
        deg = new int[n];
        int u,v;
        for (int i=0;i<n;++i)
            E.put(i, new HashMap<>());
        for (int[] edge : edges) {
            u = edge[0] - 1; v = edge[1] - 1;
            insert(u,v);
            insert(v,u);
        }

        rbTree = new RbTree<>();
        for (int e : deg) rbTree.insert(e);

        int [] result = new int [queries.length];
        for (int i=0;i<queries.length;++i) {
            result[i] = solve(queries[i]);
        }
        return result;
    }
}
