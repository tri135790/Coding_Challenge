package leetcode75.level1;

import leetcode75.level1.TreeNode.TreeNode;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isSymnetric(root.left, root.right);
    }

    private boolean isSymnetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null) {
            return false;
        } else {
            if (left.val == right.val) {
                if (isSymnetric(left.left, right.right) && isSymnetric(right.left,
                    left.right)) {
                    return true;
                }
                return false;
            }
            return false;
        }
    }
}
