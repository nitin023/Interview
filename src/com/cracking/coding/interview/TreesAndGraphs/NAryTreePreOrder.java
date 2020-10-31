package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NAryTreePreOrder {
    public List<Integer> preorder(NAryTreePostorderTraversal.Node root) {
        List<Integer> preorderTraversal = new ArrayList();

        helperPreorderIterative(root, preorderTraversal);
        return preorderTraversal;
    }

    private void helperPreorderRecursive(NAryTreePostorderTraversal.Node root, List<Integer> preorderTraversal) {

        if (root == null) {
            return;
        }
        preorderTraversal.add(root.val);

        for (NAryTreePostorderTraversal.Node child : root.children) {
            helperPreorderRecursive(child, preorderTraversal);
        }
    }

    private void helperPreorderIterative(NAryTreePostorderTraversal.Node root, List<Integer> preorderTraversal) {
        if (root == null) {
            return;
        }

        Stack<NAryTreePostorderTraversal.Node> stack = new Stack();
        stack.add(root);

        while (!stack.isEmpty()) {
            NAryTreePostorderTraversal.Node item = stack.pop();
            preorderTraversal.add(item.val);

            for (int i = item.children.size() - 1; i >= 0; i--) {
                stack.add(item.children.get(i));
            }

        }
    }
}
