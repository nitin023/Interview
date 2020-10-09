package com.cracking.coding.interview.TreesAndGraphs;

public class ConstructBSTFromSortedArray {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildBSTFromArray(0, nums.length - 1, nums);
    }


    private TreeNode buildBSTFromArray(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        int middleIndex = (start + end) / 2;
        TreeNode node = new TreeNode(nums[middleIndex]);
        node.left = buildBSTFromArray(start, middleIndex - 1, nums);
        node.right = buildBSTFromArray(middleIndex + 1, end, nums);
        return node;
    }
}
