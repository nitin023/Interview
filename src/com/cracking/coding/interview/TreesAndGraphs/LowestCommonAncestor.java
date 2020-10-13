package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Medium
 */
public class LowestCommonAncestor {

    class Solution {
        /**
         * This approach is length but a very easy solution to learn
         * it starts with finding the path from root to given node
         * then reverse iterating the path to find the common ancestor
         * This requires extra space for finding solution
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if (root == null || p == null || q == null) {
                return null;
            }
            List<TreeNode> pathP = new ArrayList();
            List<TreeNode> pathQ = new ArrayList();

            getPathFromRootToNode(root, p, pathP);
            getPathFromRootToNode(root, q, pathQ);

            Set<TreeNode> pathPSet = new HashSet(pathP);
            for (TreeNode node : pathQ) {
                if (pathPSet.contains(node)) {
                    return node;
                }
            }
            return null;
        }

        private boolean getPathFromRootToNode(TreeNode root, TreeNode dest, List<TreeNode> pathList) {
            if (root == null) {
                return false;
            }

            if (root == dest || getPathFromRootToNode(root.left, dest, pathList) || getPathFromRootToNode(root.right, dest, pathList)) {
                pathList.add(root);
                return true;
            }
            return false;
        }

        /**
         * O(h) space and O(N) time
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestorFastest(TreeNode root, TreeNode p, TreeNode q) {

            if (root == null) {
                return null;
            }

            if (root == p || root == q) {
                return root;
            }

            TreeNode left = lowestCommonAncestorFastest(root.left, p, q);
            TreeNode right = lowestCommonAncestorFastest(root.right, p, q);

            if (left == null && right == null) {
                return null;
            }

            if (left != null && right != null) {
                return root;
            }

            return left != null ? left : right;
        }
    }
}
