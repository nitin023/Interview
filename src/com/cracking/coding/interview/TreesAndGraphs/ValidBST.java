package com.cracking.coding.interview.TreesAndGraphs;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class ValidBST {
    /**
     * O(N) and O(N) memory usage
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        //inorder traversal if sorted it is done

        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList();
        getInorderTraversal(root, list);
        return checkForBST(list);
    }

    private void getInorderTraversal(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }
        getInorderTraversal(node.left, list);
        list.add(node.val);
        getInorderTraversal(node.right, list);
    }

    private boolean checkForBST(List<Integer> list) {
        for (int i = 0; i + 1 < list.size(); i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }
}
