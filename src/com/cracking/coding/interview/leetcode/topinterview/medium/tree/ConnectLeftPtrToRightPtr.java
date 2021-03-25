package com.cracking.coding.interview.leetcode.topinterview.medium.tree;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Medium
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class ConnectLeftPtrToRightPtr {
    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<List<TreeNode>> levelTraversal = getLevelOrderTraversal(root);
        connectLevelWise(levelTraversal);
        return root;
    }

    private List<List<TreeNode>> getLevelOrderTraversal(TreeNode node) {
        List<List<TreeNode>> records = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(node);

        while (!queue.isEmpty()) {
            int count = queue.size();
            List<TreeNode> levelOrderList = new ArrayList<>();
            while (count > 0) {
                TreeNode currentNode = queue.peek();
                levelOrderList.add(currentNode);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                queue.remove();
                count--;
            }
            records.add(levelOrderList);
        }
        return records;
    }

    private void connectLevelWise(List<List<TreeNode>> levelTraversal) {

        for (List<TreeNode> level : levelTraversal) {
            for (int i = 0; i + 1 < level.size(); i++) {
                level.get(i).next = level.get(i + 1);
            }
        }
    }

    /*Best Solution*/
    private void connectHelperUsingRecursion(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }

        connectHelperUsingRecursion(root.left);
        connectHelperUsingRecursion(root.right);
    }
}
