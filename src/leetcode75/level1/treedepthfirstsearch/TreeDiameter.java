package leetcode75.level1.treedepthfirstsearch;

import java.util.HashMap;
import java.util.Map;

class TreeDiameter {

    public static int findDiameter(TreeNode root) {
        Map<TreeNode, Integer> longestPaths = new HashMap<>();
        longestPaths.put(null, 0);
        return dfs(root, longestPaths);
    }

    private static int dfs(TreeNode node, Map<TreeNode, Integer> longestPaths) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            longestPaths.put(node, 1);
            return 1;
        }

        int diameterLeft = dfs(node.left, longestPaths);
        int diameterRight = dfs(node.right, longestPaths);

        int diameterNode = 1 + longestPaths.get(node.left) + longestPaths.get(node.right);

        longestPaths.put(node, Math.max(longestPaths.get(node.left), longestPaths.get(node.right)) + 1);

        return Math.max(diameterNode, Math.max(diameterLeft,
            diameterRight
        ));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
