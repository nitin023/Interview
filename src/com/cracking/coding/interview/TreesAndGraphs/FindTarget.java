package com.cracking.coding.interview.TreesAndGraphs;

import java.util.HashSet;
import java.util.Set;

public class FindTarget {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        System.out.println(findTargetHelper(root ,root, 2));
    }

    private static boolean findTargetHelper(TreeNode root , TreeNode curr ,int k){
        if(curr == null) {return false;}
        return search(root , curr , k - curr.val) || findTargetHelper(root , curr.left , k) || findTargetHelper(root , curr.right , k);
    }

    private static boolean search(TreeNode root ,TreeNode curr ,  int key){
        if(root == null) {return false;}
        return root.val == key && curr!= root || root.val < key && search(root.right,curr , key) || root.val> key && search(root.left,curr , key);
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> visitedNodes = new HashSet();
        return findTargetHelperUsingSet(root , visitedNodes , k);
    }

    //Uses Hash set for determining pair sum problem solution easiest and best solution.
    private boolean findTargetHelperUsingSet(TreeNode root ,Set<Integer> visitedNodes , int k){

        if(root == null) {return false;}

        if(visitedNodes.contains(k - root.val)){
            return true;
        }

        visitedNodes.add(root.val);

        return findTargetHelperUsingSet(root.left , visitedNodes , k) ||  findTargetHelperUsingSet(root.right , visitedNodes , k);

    }
}


