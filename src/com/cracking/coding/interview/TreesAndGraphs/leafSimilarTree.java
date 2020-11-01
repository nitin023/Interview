package com.cracking.coding.interview.TreesAndGraphs;

/**
 * Easy
 * https://leetcode.com/problems/leaf-similar-trees/
 */
public class leafSimilarTree {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        StringBuilder root1Pattern = new StringBuilder();
        getLeafSequencePattern(root1, root1Pattern);

        StringBuilder root2Pattern = new StringBuilder();
        getLeafSequencePattern(root2, root2Pattern);


        return root1Pattern.toString().equals(root2Pattern.toString());
    }

    private String getLeafSequencePattern(TreeNode root, StringBuilder response) {

        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            response.append(root.val).append(" ");
        }

        getLeafSequencePattern(root.left, response);

        getLeafSequencePattern(root.right, response);

        return response.toString();
    }
}
