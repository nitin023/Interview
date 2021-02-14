package com.cracking.coding.interview.leetcode.topinterview.recursion.medium;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Medium
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class RightViewOfBinaryTree {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightViewList = new ArrayList();
        rightSideViewHelper(root, rightViewList, 0);
        return rightViewList;
    }

    private void rightSideViewHelper(TreeNode root, List<Integer> rightViewList, int currentDepth) {
        if (root == null) {
            return;
        }

        if (rightViewList.size() == currentDepth) {
            rightViewList.add(root.val);
        }
        rightSideViewHelper(root.right, rightViewList, currentDepth + 1);
        rightSideViewHelper(root.left, rightViewList, currentDepth + 1);
    }

    private void getRightViewUsingLevelOrderTraversal(TreeNode root, List<Integer> rightViewList) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            List<Integer> levelList = new ArrayList<>();
            while (size > 0) {
                TreeNode node = nodeQueue.remove();
                levelList.add(node.val);
                if (node.left != null) {
                    nodeQueue.add(node.left);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                }
                size--;
            }
            int levelSize = levelList.size();
            int lastElementOfLevel = levelList.get(levelSize - 1);
            rightViewList.add(lastElementOfLevel);
        }
    }
}
