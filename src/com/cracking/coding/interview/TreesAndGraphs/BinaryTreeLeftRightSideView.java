package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Get The level order traversal just inside each list look for end index in
 * case of right view and 0 index in case of left view
 */
public class BinaryTreeLeftRightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        getRightView(root);
    }

    private static List<Integer> getRightView(TreeNode root) {
        List<Integer> rightView = new ArrayList();
        List<TreeNode> queue = new ArrayList();
        queue.add(root);

        int cnt;
        List<List<Integer>> levelList = new ArrayList<>();
        while (!queue.isEmpty()) {
            cnt = queue.size();
            List<Integer> tempList = new ArrayList<>();
            while (cnt > 0) {
                TreeNode node = queue.remove(0);
                tempList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                cnt--;
            }
            levelList.add(tempList);
        }
        for (List<Integer> entry : levelList) {
            rightView.add(entry.get(entry.size() - 1));
        }
        return rightView;
    }

    private static List<Integer> getLeftView(TreeNode root) {
        List<Integer> leftView = new ArrayList();
        List<TreeNode> queue = new ArrayList();
        queue.add(root);

        int cnt;
        List<List<Integer>> levelList = new ArrayList<>();
        while (!queue.isEmpty()) {
            cnt = queue.size();
            List<Integer> tempList = new ArrayList<>();
            while (cnt > 0) {
                TreeNode node = queue.remove(0);
                tempList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                cnt--;
            }
            levelList.add(tempList);
        }
        for (List<Integer> entry : levelList) {
            leftView.add(entry.get(0));
        }
        return leftView;
    }
}
