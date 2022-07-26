package leetcode75.level1;

import java.util.ArrayList;
import java.util.List;

import leetcode75.level1.TreeNode.Node;

public class NaryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            for (Node node : root.children) {
                preOrder(node, list);
            }
        }
    }
}
