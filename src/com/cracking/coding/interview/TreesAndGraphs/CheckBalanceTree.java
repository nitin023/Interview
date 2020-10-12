package com.cracking.coding.interview.TreesAndGraphs;

/**
 * 4.4 Check Balanced
 */
public class CheckBalanceTree {
    /**
     * O(nlogn) solution
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftSubTreeHeight = depth(root.left);
        int rightSubTreeHeight = depth(root.right);

        int diff = Math.abs(leftSubTreeHeight - rightSubTreeHeight);

        return diff <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    /**
     * O(n) solution
     * @param root
     * @return
     */
    public boolean isBalancedFastest(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    private int checkHeight(TreeNode root)
    {
        if(root == null) {return -1;}
        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE)
        {
            return Integer.MIN_VALUE;
        }
        int rightHeight = checkHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE)
        {
            return Integer.MIN_VALUE;
        }

        int heightDiff = Math.abs(leftHeight - rightHeight);
        if(heightDiff > 1)
        {
            return Integer.MIN_VALUE;
        }
        else
        {
            return Math.max(leftHeight , rightHeight) + 1;
        }
    }
}