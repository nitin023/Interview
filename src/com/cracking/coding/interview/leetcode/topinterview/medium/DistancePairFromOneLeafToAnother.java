package com.cracking.coding.interview.leetcode.topinterview.medium;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.*;

/**
 * Medium
 * https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
 */
public class DistancePairFromOneLeafToAnother {
    static int res = 0;

    public static int countPairs(TreeNode root, int d) {
        dfs(root, d);
        return res;
    }

    public static int[] dfs(TreeNode root, int distance) {
        if (root == null) return new int[0];
        if (root.left == null && root.right == null) return new int[]{1};
        int[] left = dfs(root.left, distance), right = dfs(root.right, distance);
        for (int l : left)
            for (int r : right)
                if (l + r <= distance) res++;
        int idx = 0;
        int[] cur = new int[left.length + right.length];
        for (int l : left) cur[idx++] = l + 1;
        for (int r : right) cur[idx++] = r + 1;
        return cur;
    }
}

