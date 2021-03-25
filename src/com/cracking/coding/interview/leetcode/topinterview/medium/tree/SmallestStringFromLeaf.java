package com.cracking.coding.interview.leetcode.topinterview.medium.tree;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * https://leetcode.com/problems/smallest-string-starting-from-leaf
 */
public class SmallestStringFromLeaf {
    List<String> leafToRootPathString = new ArrayList<>();

    public String smallestFromLeaf(TreeNode root) {
        getLeafToRootPath(root, new StringBuilder());
        return getLexicographicallySmallString();
    }

    private void getLeafToRootPath(TreeNode root, StringBuilder pathString) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            pathString.append(getCharacterFromValue(root.val));
            leafToRootPathString.add(pathString.reverse().toString());
        }

        pathString.append(getCharacterFromValue(root.val));

        getLeafToRootPath(root.left, new StringBuilder(pathString));

        getLeafToRootPath(root.right, new StringBuilder(pathString));

    }

    private String getLexicographicallySmallString() {

        if (leafToRootPathString.isEmpty()) {
            return null;
        }

        String firstStr = leafToRootPathString.get(0);
        for (int i = 1; i < leafToRootPathString.size(); i++) {
            String secondStr = leafToRootPathString.get(i);
            int result = firstStr.compareTo(secondStr);
            if (result > 0) {
                firstStr = secondStr;
            }
        }
        return firstStr;
    }

    private char getCharacterFromValue(int value) {
        int offset = 97;
        return (char) (value + offset);
    }
}
