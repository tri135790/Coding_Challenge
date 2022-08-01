package leetcode75.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode75.level1.TreeNode.TreeNode;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null)
            return true;
        if ((min != null && root.val <= min.val) || (max != null && root.val >= max.val))
            return false;

        return helper(root.left, min, root) && helper(root.right, root, max);
    }
}
