package com.cracking.coding.interview.leetcode.topinterview.medium.tree;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * https://leetcode.com/problems/path-sum-ii
 */
public class PathSum2 {
    List<List<Integer>> allpathsList = new ArrayList();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {


        getPathsWithTargetSum(root, targetSum, new ArrayList<>());

        return allpathsList;
    }

    private void getPathsWithTargetSum(TreeNode root, int targetSum, List<Integer> levelList) {
        if (root == null) {
            return;
        }

        if (targetSum == root.val && root.left == null && root.right == null) {
            allpathsList.add(levelList);
        }

        levelList.add(root.val);

        getPathsWithTargetSum(root.left, targetSum - root.val, new ArrayList<>(levelList));

        getPathsWithTargetSum(root.right, targetSum - root.val, new ArrayList<>(levelList));
    }
}
