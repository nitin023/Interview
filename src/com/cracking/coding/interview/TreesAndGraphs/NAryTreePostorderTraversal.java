package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */
public class NAryTreePostorderTraversal {
    /**
     * Recursive
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> postOrderTraversal = new ArrayList();
        helperPostOrderTraversal(root, postOrderTraversal);
        return postOrderTraversal;
    }

    private void helperPostOrderTraversal(Node root, List<Integer> postOrderTraversal) {
        if (root == null) {
            return;
        }

        for (Node node : root.children) {
            helperPostOrderTraversal(node, postOrderTraversal);
        }

        postOrderTraversal.add(root.val);
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

}
