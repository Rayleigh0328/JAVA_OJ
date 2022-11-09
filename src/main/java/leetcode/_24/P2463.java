package leetcode._24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P2463 {


    private static final long inf = (1L<<55);

    private static class Factory implements Comparable<Factory> {
        int pos;
        int limit;

        public Factory(int pos, int limit) {
            this.pos = pos;
            this.limit = limit;
        }

        @Override
        public int compareTo(Factory o) {
            return Integer.compare(pos, o.pos);
        }
    }


    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        ArrayList<Factory> factories = Arrays.stream(factory)
            .filter(e -> e[1] > 0)
            .map(e -> new Factory(e[0], e[1]))
            .sorted(Factory::compareTo)
            .collect(Collectors.toCollection(ArrayList::new));
        int n = factories.size();

        ArrayList<Integer> robots = robot.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
        int m = robot.size();

        long [][] f = new long [n][m+1];
        for (int i=0;i<n;++i)
            for (int j=0;j<=m;++j)
                f[i][j] = inf;

        // init f[0]
        f[0][0] = 0;
        for (int j=1;j<=m;++j) {
            if (j <= factories.get(0).limit) {
                f[0][j] = f[0][j-1] + getDist(0,j-1,factories,robots);
            }
        }

        // dp
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= m; ++j) {
                f[i][j] = f[i-1][j]; // factory[i] process nothing
                long sum = 0;
                for (int k=j-1;k>=0 && j-k<=factories.get(i).limit;--k) {
                    sum += getDist(i,k,factories,robots);
                    f[i][j] = Math.min(f[i][j], sum + f[i-1][k]);
                }
            }
        }

        return f[n-1][m];
    }

    private long getDist(int i, int j, ArrayList<Factory> factories, ArrayList<Integer> robots) {
        return Math.abs(factories.get(i).pos - robots.get(j));
    }


}
