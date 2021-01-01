package leetcode;

import lib.string.trie.BinaryTrieNodeWithData;
import lib.string.trie.ITrieNode;
import lib.string.trie.Trie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class P1707 {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        // sort queries by upperbound
        // strings in the trie will always be smaller than the current upperbound
        TreeSet<Integer> s = new TreeSet();
        for (int x : nums) s.add(x);
        for (int i=0;i<queries.length;++i) {
            int tmp[] = {queries[i][0], queries[i][1], i, -1};
            queries[i] = tmp;
        }
        Arrays.sort(queries, Comparator.comparingInt(x -> x[1]));

        List<Character> prefList = Arrays.asList('0','1');
        BinaryTrieNodeWithData<Integer> root = new BinaryTrieNodeWithData<>();
        Trie trie = new Trie(root);

        int data, limit, tmp;
        String str;
        ITrieNode node;
        BinaryTrieNodeWithData<Integer> nodeWithData;
        // construct
        for (int[] query : queries) {
            data = query[0];
            limit = query[1];
            while (!s.isEmpty() && s.first() <= limit) {
                tmp = s.first();
                s.remove(tmp);
                str = convertToBitString(tmp);
                ((BinaryTrieNodeWithData<Integer>) trie.insertString(str)).setData(tmp);
            }
            str = convertToBitString(~data);
            node = trie.findWithPreference(str, prefList);
            if (node != null) {
                nodeWithData = ((BinaryTrieNodeWithData<Integer>) node);
                if (nodeWithData.getData() != null) {
                    query[3] = (nodeWithData.getData() ^ data);
                }
            }
        }

        Arrays.sort(queries, Comparator.comparingInt(x -> x[2]));
        int resultArray [] = new int [queries.length];
        for (int i=0;i<queries.length;++i)
            resultArray[i] = queries[i][3];
        return resultArray;
    }

    private String convertToBitString(Integer k){
        StringBuffer sb = new StringBuffer();
        for (int i=29;i>=0;--i) {
            if ((k & (1 << i)) == 0) sb.append('0');
            else sb.append('1');
        }
        return sb.toString();
    }
}
