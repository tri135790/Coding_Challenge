package leetcode75.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode75.level1.TreeNode.TreeNode;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue queue = new LinkedList();
        levelOrderList(root, list, 0);

        return list;
    }

    //Solution using DFS and height
    private void levelOrderList(TreeNode root, List<List<Integer>> list, Integer height) {
        if (root == null) return;
        if (list.size() <= height) {
            List<Integer> newList = new ArrayList<>();
            list.add(newList);
        }
        list.get(height).add(root.val);
        levelOrderList(root.left, list, height + 1);
        levelOrderList(root.right, list, height + 1);
    }


    //Solution using BFS and queue
    private List<List<Integer>> usingQueue (TreeNode root, List<List<Integer>> list) {
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i ++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(level);
        }
        return list;

    }
}
