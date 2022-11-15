package leetcode._24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P2467 {

    private static final int MAX_SIZE = 100_005;

    private Map<Integer, ArrayList<Integer>> g = new HashMap();
    private ArrayList<Integer> bobPath = new ArrayList();
    private boolean foundBobPath = false;
    private int [] f = new int[MAX_SIZE];
    private boolean [] isLeaf = new boolean[MAX_SIZE];
    private boolean [] visited = new boolean[MAX_SIZE];
    private int [] depth = new int [MAX_SIZE];

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {

        final int n = edges.length + 1;

        for (int i=0;i<n;++i) g.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }

        for (int i=0;i<n;++i) visited[i] = false;
        for (int i=0;i<n;++i) isLeaf[i] = false;
        dfsLeaf(0, 0);

        for (int i=0;i<n;++i) visited[i] = false;
        bobPath.add(0);
        dfsBob(0, bob);
        Collections.reverse(bobPath);

        for (int i=0;i<n;++i) visited[i] = false;
        Queue<Integer> queue = new LinkedList<>();
        f[0] = amount[0];
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (depth[cur] < bobPath.size()) {
                amount[bobPath.get(depth[cur])] = 0;
            }
            for (Integer next : g.get(cur)) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.add(next);
                if (depth[next] < bobPath.size() && next == bobPath.get(depth[next])) {
                    f[next] = f[cur] + amount[next] / 2;
                }
                else {
                    f[next] = f[cur] + amount[next];
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i=0;i<n;++i)
            if (isLeaf[i]) result = Math.max(result, f[i]);
        return result;
    }

    private void dfsLeaf(int cur, int d) {
        visited[cur] = true;
        depth[cur] = d;
        boolean hasChild = false;
        for (Integer next : g.get(cur)) {
            if (visited[next]) continue;

            dfsLeaf(next, d + 1);
            hasChild = true;
        }
        isLeaf[cur] = !hasChild;
    }

    private void dfsBob(int cur, int target) {
        visited[cur] = true;
        if (cur == target) {
            foundBobPath = true;
            return;
        }
        for (Integer next : g.get(cur)) {
            if (visited[next]) continue;
            if (foundBobPath) return;
            bobPath.add(next);
            dfsBob(next, target);
            if (!foundBobPath) bobPath.remove(bobPath.size() - 1);
        }
    }

}
