package leetcode._24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2476 {

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
        List<List<Integer>> result = new ArrayList<>();
        for (Integer query : queries) {
            result.add(solve(root, query));
        }
        return result;
    }

    private List<Integer> solve(TreeNode root, Integer target) {
        return Arrays.asList(getPredecessor(root, target), getSuccessor(root,target));
    }

    private Integer getPredecessor(TreeNode cur, Integer target) {
        if (cur == null) return -1;
        if (cur.val == target) return target;
        if (cur.val > target) return getPredecessor(cur.left, target);
        else {
            Integer result = getPredecessor(cur.right, target);
            return result == -1 ? cur.val : result;
        }
    }

    private Integer getSuccessor(TreeNode cur, Integer target) {
        if (cur == null) return -1;
        if (cur.val == target) return target;
        if (cur.val < target) return getSuccessor(cur.right, target);
        else {
            Integer result = getSuccessor(cur.left, target);
            return result == -1 ? cur.val : result;
        }
    }

}
