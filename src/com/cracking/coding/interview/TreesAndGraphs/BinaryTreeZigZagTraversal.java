package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        return getZigZagLevelOrderTraversal(root);
    }

    private List<List<Integer>> getZigZagLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> zigZagTraversal = new ArrayList();
        List<TreeNode> levelQueue = new ArrayList();
        levelQueue.add(root);
        int level = 0;

        while (!levelQueue.isEmpty()) {
            int count = levelQueue.size();
            List<Integer> levelList = new ArrayList();
            while (count > 0) {
                TreeNode node = levelQueue.remove(0);
                levelList.add(node.val);
                if (node.left != null) {
                    levelQueue.add(node.left);
                }
                if (node.right != null) {
                    levelQueue.add(node.right);
                }
                count--;
            }
            if (level % 2 == 0) {
                zigZagTraversal.add(levelList);
            } else {
                List<Integer> test = new ArrayList();
                for (int i = levelList.size() - 1; i >= 0; i--) {
                    test.add(levelList.get(i));
                }
                zigZagTraversal.add(test);
            }
            level++;
        }
        return zigZagTraversal;
    }
}
