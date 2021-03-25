package com.cracking.coding.interview.leetcode.topinterview.medium.tree;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 */

public class SortedMergeListInBST {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> traversalList1 = new ArrayList();
        getInorderTraversal(root1, traversalList1);
        List<Integer> traversalList2 = new ArrayList();
        getInorderTraversal(root2, traversalList2);
        return merge(traversalList1, traversalList1.size(), traversalList2, traversalList2.size());
    }

    private void getInorderTraversal(TreeNode root, List<Integer> traversalList) {
        if (root == null) {
            return;
        }

        getInorderTraversal(root.left, traversalList);
        traversalList.add(root.val);
        getInorderTraversal(root.right, traversalList);
    }

    public List<Integer> merge(List<Integer> nums1, int m, List<Integer> nums2, int n) {

        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1.get(i) <= nums2.get(j)) {
                result.add(nums1.get(i++));
            } else {
                result.add(nums2.get(j++));
            }
        }

        while (i < m) {
            result.add(nums1.get(i++));
        }

        while (j < n) {
            result.add(nums2.get(j++));
        }
        return result;
    }

}
