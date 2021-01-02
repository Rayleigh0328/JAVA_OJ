package leetcode._16;

import lib.disjoint_set.DisjointSet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class P1697 {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, Comparator.comparingInt(x -> x[2]));
        int [][] qs = new int [queries.length][];
        for (int i=0;i<queries.length;++i){
            qs[i] = new int [5];
            qs[i][0] = queries[i][0];
            qs[i][1] = queries[i][1];
            qs[i][2] = queries[i][2];
            qs[i][3] = i;
        }
        Arrays.sort(qs, Comparator.comparingInt(x -> x[2]));
        DisjointSet ds = new DisjointSet(n);
        int p = 0;
        for (int[] q : qs) {
            while (p < edgeList.length && edgeList[p][2] < q[2]) {
                ds.unionSet(edgeList[p][0], edgeList[p][1]);
                ++p;
            }
            q[4] = (ds.findSet(q[0]) == ds.findSet(q[1])?1:0);
        }
        Arrays.sort(qs, Comparator.comparingInt(x -> x[3]));
        boolean [] result = new boolean [qs.length];
        for (int i=0;i<qs.length;++i)
            result[i] = (qs[i][4]==1?true:false);
        return result;

//        return Arrays.stream(qs)
//            .map(q -> (q[4]==1?true:false))
//            .collect(TO_BOOLEAN_ARRAY);
    }

    public static final Collector<Boolean, ?, boolean[]> TO_BOOLEAN_ARRAY
        = Collectors.collectingAndThen(Collectors.toList(), P1697::listToArray);

    public static boolean[] listToArray(List<Boolean> list) {
        int length = list.size();
        boolean[] arr = new boolean[length];
        for (int i = 0; i < length; ++i) arr[i] = list.get(i);
        return arr;
    }
}
