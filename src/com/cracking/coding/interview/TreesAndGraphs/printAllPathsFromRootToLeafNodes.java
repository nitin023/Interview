package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class printAllPathsFromRootToLeafNodes {

    /**
     * https://leetcode.com/problems/binary-tree-paths/
     * Easy
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>response = new ArrayList();
        if(root == null) {return response;}

        String currentPath = Integer.toString(root.val);
        if(root.left == null && root.right ==null){
            response.add(currentPath);
        }

        if(root.left != null)
        {
            dfs(root.left , currentPath, response);
        }
        if(root.right != null)
        {
            dfs(root.right , currentPath, response);
        }
        return response;
    }

    private void dfs(TreeNode node , String currentPath , List<String> response){
        currentPath += "->" + node.val;

        if(node.left == null && node.right == null)
        {
            response.add(currentPath);
            return;
        }
        if(node.left != null)
        {
            dfs(node.left , currentPath, response);
        }
        if(node.right != null)
        {
            dfs(node.right , currentPath, response);
        }
    }
}
