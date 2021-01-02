package leetcode._13;

import java.util.Deque;
import java.util.LinkedList;

public class P1379_2 {

    private Deque<Boolean> state = new LinkedList<>();
    private Boolean flag = false;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfsGenerateState(original, target);
        TreeNode cur = cloned;
        while (!state.isEmpty()) {
            if (state.pollFirst()) {
                cur = cur.right;
            }
            else {
                cur = cur.left;
            }
        }
        return cur;
    }

    private void dfsGenerateState(TreeNode u, TreeNode target){
        if (u == null) return;
        if (u == target) {
            flag = true;
            return;
        }

        state.addLast(false);
        dfsGenerateState(u.left, target);
        if (flag) return;
        state.pollLast();

        state.addLast(true);
        dfsGenerateState(u.right, target);
        if (flag) return;
        state.pollLast();
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

