package com.cracking.coding.interview.leetcode.topinterview.easy;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Easy
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tre
 */
public class ConvertSortedTreeToBST {

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{1,2,3,4,5});
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBSTHelper(int nums[], int start, int end) {
        if (start > end) {
            return null;
        }

        int middleElemIndex = (start + end) / 2;

        TreeNode node = new TreeNode(nums[middleElemIndex]);

        node.left = sortedArrayToBSTHelper(nums, start, middleElemIndex - 1);

        node.right = sortedArrayToBSTHelper(nums, middleElemIndex + 1, end);

        return node;
    }
}
