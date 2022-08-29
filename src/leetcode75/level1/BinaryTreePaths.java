package leetcode75.level1;

import java.util.ArrayList;
import java.util.List;

import leetcode75.level1.TreeNode.TreeNode;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root != null) traverse(root, "", answer);
        return answer;
    }

    public void traverse(TreeNode node, String path, List<String> answer) {
        if (node.left == null && node.right == null) answer.add(path + node.val);
        if (node.left != null) traverse(node.left, path + node.val + "->", answer);
        if (node.right != null) traverse(node.right, path + node.val + "->", answer);
    }
}
