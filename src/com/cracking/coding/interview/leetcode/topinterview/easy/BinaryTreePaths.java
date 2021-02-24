package com.cracking.coding.interview.leetcode.topinterview.easy;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

    List<String> resultPathList = new ArrayList();

    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null) {
            return resultPathList;
        }
        pathFinder(root, new StringBuilder());
        return resultPathList;
    }

    private void pathFinder(TreeNode root, StringBuilder pathFormat) {
        if (root == null) {
            return;
        }

        int length = pathFormat.length();

        if (root.left == null && root.right == null) {
            pathFormat.append(root.val);
            resultPathList.add(pathFormat.toString());
            pathFormat.delete(length, pathFormat.length());
            return;
        }

        pathFormat.append(root.val).append("->");

        pathFinder(root.left, pathFormat);

        pathFinder(root.right, pathFormat);

        pathFormat.delete(length, pathFormat.length());
    }
}
