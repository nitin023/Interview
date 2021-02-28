package com.cracking.coding.interview.leetcode.topinterview.medium;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * Right View Of Binary Tree
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Solution
 * follow level wise dfs and locate right node first
 * followed by left node
 * and if an element has not been added for a level
 * add that element
 */
public class TreeRightView {

    List<Integer> rightSideViewList = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return rightSideViewList;
        }
        dfs(root, 0);
        return rightSideViewList;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (level == rightSideViewList.size()) {
            rightSideViewList.add(node.val);
        }

        dfs(node.right, level + 1);

        dfs(node.left, level + 1);
    }
}
