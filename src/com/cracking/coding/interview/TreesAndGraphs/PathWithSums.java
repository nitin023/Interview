package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/path-sum-ii
 * Medium
 */
public class PathWithSums {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return new ArrayList();
        }

        List<List<Integer>> paths = new ArrayList();
        findPaths(root , sum , new ArrayList() , paths);
        return paths;
    }

    private void findPaths(TreeNode root , int sum , List<Integer> path , List<List<Integer>> paths)
    {
        //base case
        if(root == null){return;}

        path.add(root.val);

        if(root.val == sum && root.left == null && root.right == null)
        {
            paths.add(path);
            return;
        }

        findPaths(root.left , sum - root.val , new ArrayList(path) , paths);

        findPaths(root.right , sum - root.val , new ArrayList(path) , paths);
    }
}
