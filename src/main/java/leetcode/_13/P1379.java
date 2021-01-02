package leetcode._13;

public class P1379 {
    TreeNode dfs(TreeNode u, TreeNode v, TreeNode target){
        if (u == null) return null;
        if (u == target) return v;

        TreeNode result = dfs(u.left, v.left, target);
        if (result != null) return result;

        result = dfs(u.right, v.right, target);

        return result;
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(original, cloned, target);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


