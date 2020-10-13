package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Medium
 * Finding path from root to given node
 */
public class PrintPathFromRootToNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode n1 = new TreeNode(4);
        root.left.left = n1;
        root.left.right = new TreeNode(5);
        TreeNode n2 = new TreeNode(8);
        root.left.right.right = n2;
        root.left.right.left = new TreeNode(7);

        List<TreeNode> pathList = new ArrayList<>();
        getPathFromRootToNode(root, n2, pathList);

        Collections.reverse(pathList);
        for (TreeNode node : pathList) {
            System.out.println(node.val + " ");
        }
    }

    public static boolean getPathFromRootToNode(TreeNode root, TreeNode dest, List<TreeNode> pathList) {
        if (root == null) {
            return false;
        }

        if (root == dest || getPathFromRootToNode(root.left, dest, pathList) || getPathFromRootToNode(root.right, dest, pathList)) {
            pathList.add(root);
            return true;
        }
        return false;
    }
}
