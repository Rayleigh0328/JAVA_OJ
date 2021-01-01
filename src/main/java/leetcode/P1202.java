package leetcode;

import lib.disjoint_set.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class P1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        final int n = s.length();

        // group chars in s
        DisjointSet ds = new DisjointSet(n);
        int u,v;
        for (List<Integer> pair : pairs) {
            u = pair.get(0);
            v = pair.get(1);
            ds.unionSet(u,v);
        }

        // put each char into its corresponding bucket
        List<List<Character>> buckets = new ArrayList();
        for (int i=0;i<n;++i) buckets.add(new ArrayList());
        for (int i=0;i<n;++i){
            List<Character> bucket = buckets.get(ds.findSet(i));
            bucket.add(s.charAt(i));
            Iterator<Character> it =  bucket.iterator();
            it.next();
        }

        // sort
        for (List<Character> bucket : buckets) {
            Collections.sort(bucket);
        }

        // construct answer
        List<Iterator<Character>> iterators= new ArrayList();
        for (int i=0;i<n;++i) {
            iterators.add(buckets.get(i).iterator());
        }

        StringBuffer sb = new StringBuffer();
        for (int i=0;i<n;++i) {
            Iterator<Character> it = iterators.get(ds.findSet(i));
            sb.append(it.next());
        }
        return sb.toString();
    }
}
