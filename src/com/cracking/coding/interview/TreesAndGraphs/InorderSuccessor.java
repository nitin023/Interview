package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessor {

    /**
     * O(n) complexity
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        List<TreeNode> inorderList = new ArrayList();
        getInorderList(inorderList, root);
        return getNode(inorderList, p);
    }

    private void getInorderList(List<TreeNode> inorderList, TreeNode root) {
        if (root == null) {
            return;
        }
        getInorderList(inorderList, root.left);
        inorderList.add(root);
        getInorderList(inorderList, root.right);
    }

    private TreeNode getNode(List<TreeNode> inorderList, TreeNode p) {
        if (p == null) {
            return null;
        }

        for (int i = 0; i < inorderList.size(); i++) {
            if (inorderList.get(i) == p) {
                if (inorderList.size() == i + 1) {
                    return null;
                }
                return inorderList.get(i + 1);
            }
        }
        return null;
    }

    /**
     * O(n) get the in order successor
     * @param root
     * @param p
     * @return
     */
    public TreeNodeWithParent inorderSuccessorFastest(TreeNodeWithParent root, TreeNodeWithParent p) {
        if (root == null) {
            return null;
        }

        if (root.right != null) {
            return getLeftMostNode(root);
        } else {
            TreeNodeWithParent q = root;
            TreeNodeWithParent x = q.parent;
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    private TreeNodeWithParent getLeftMostNode(TreeNodeWithParent root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private class TreeNodeWithParent {
        int val;
        TreeNodeWithParent left;
        TreeNodeWithParent right;
        TreeNodeWithParent parent;

        TreeNodeWithParent() {
        }

        public TreeNodeWithParent(int val) {
            this.val = val;
        }

        public TreeNodeWithParent(int val, TreeNodeWithParent left, TreeNodeWithParent right, TreeNodeWithParent parent) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}

