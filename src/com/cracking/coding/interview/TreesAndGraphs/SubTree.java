package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class SubTree {

    /**
     * Naive Solution O(N + M)
     * Approach Solution
     * Step 1 : Look for the nodes inside the main tree T1
     * Step 2 : Look this by any traversal
     * Step 3 : If something found try to match that start node inside T1 using recursion approach
     * Step 4:  If not found start iterating the list to look for any other occurrence of the start node
     * Step 5 : If after complete iteration nothing is found return false else return true;
     *
     * @param T1
     * @param T2
     * @return
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {

        if ((T1 == null && T2 == null) || (T1 != null && T2 == null)) {
            return true;
        }

        if (T1 == null && T2 != null) {
            return false;
        }

        List<TreeNode> list = new ArrayList();
        getPreOrder(T1, list);
        return getNodeToFindInT1(list, T2);
    }

    private void getPreOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        list.add(root);
        getPreOrder(root.left, list);
        getPreOrder(root.right, list);
    }

    private boolean getNodeToFindInT1(List<TreeNode> list, TreeNode T2) {
        for (TreeNode tmp : list) {
            if (tmp.val == T2.val) {
                if (findSubTree(T2, tmp)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findSubTree(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) {
            return true;
        }

        if ((T1 != null && T2 == null) || (T1 == null && T2 != null)) {
            return false;
        }

        if (T1.val == T2.val && findSubTree(T1.left, T2.left) && findSubTree(T1.right, T2.right)) {
            return true;
        }

        return false;

    }

    /**
     * Faster Algorithm it evaluates
     * iteration by iteration to find match
     * without taking any extra space
     * @param t1
     * @param t2
     * @return
     */
    private boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        return subTree(t1, t2);
    }

    private boolean subTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        } else if (t1.val == t2.val && matchTree(t1, t2)) {
            return true;
        }
        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    private boolean matchTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else if (t1.val != t2.val) {
            return false;
        } else {
            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
        }
    }
}
