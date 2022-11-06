package leetcode._24;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2458 {

    private static class TreeNode {
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



    private Map<Integer, TreeNode> valueToNodeMap;
    private Map<TreeNode, Integer> nodeToHeightMap;
    private Map<TreeNode, Integer> nodeToLevelMap;
    private Map<Integer, List<TreeNode>> levelNodeList;

    public int[] treeQueries(TreeNode root, int[] queries) {
        valueToNodeMap = new HashMap<>();
        nodeToHeightMap = new HashMap<>();
        nodeToLevelMap = new HashMap<>();
        levelNodeList = new HashMap<>();

        dfs(root, 0);
        for (int i=0; levelNodeList.get(i) != null; ++i) {
            levelNodeList.get(i).sort(
                (u,v) -> {
                    return Integer.compare(getHeight(v), getHeight(u));
                }
            );
        }

        return Arrays.stream(queries)
            .map(e-> solve(valueToNodeMap.get(e)))
            .toArray();
    }

    private int solve(TreeNode u)  {
        int level = nodeToLevelMap.get(u);
        List<TreeNode> list = levelNodeList.get(level);

        if (u == list.get(0)) {
            if (list.size() == 1) {
                return level - 1;
            }
            else {
                return level + getHeight(list.get(1)) - 1;
            }
        }
        else {
            return level + getHeight(list.get(0)) - 1;
        }
    }

    private int getHeight(TreeNode u) {
        return nodeToHeightMap.getOrDefault(u, 0);
    }

    private void dfs(TreeNode cur, int level) {
        valueToNodeMap.put(cur.val, cur);
        nodeToLevelMap.put(cur, level);
        if (levelNodeList.get(level) == null) levelNodeList.put(level, new ArrayList<>());
        levelNodeList.get(level).add(cur);

        int height = 1;
        if (cur.left != null) {
            dfs(cur.left, level + 1);
            height = Math.max(height, nodeToHeightMap.get(cur.left) + 1);
        }
        if (cur.right != null) {
            dfs(cur.right, level + 1);
            height = Math.max(height, nodeToHeightMap.get(cur.right) + 1);
        }
        nodeToHeightMap.put(cur, height);
    }

}
