package leetcode._24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2476_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        ArrayList<Integer> tmp = new ArrayList<>();
        dfs(root, tmp);
        int [] a = tmp.stream().mapToInt(e->e).toArray();

        List<List<Integer>> result = new ArrayList<>();
        for (Integer query : queries) {
            result.add(solve(a, query));
        }
        return result;
    }

    private void dfs(TreeNode cur, ArrayList<Integer> list) {
        if (cur == null) return;
        dfs(cur.left, list);
        list.add(cur.val);
        dfs(cur.right, list);
    }

    // https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#binarySearch(byte[],%20byte)
    private List<Integer> solve(int [] a, Integer target) {
        int index = Arrays.binarySearch(a, target);
        if (index >= 0) return Arrays.asList(a[index], a[index]);
        index += 1;
        index *= -1;
        return Arrays.asList(
            index == 0 ? -1 : a[index - 1],
            index == a.length ? -1 : a[index]
        );
    }


}
