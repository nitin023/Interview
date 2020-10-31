package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderIterativeTraversal {

    public void printPostOrderIterativeTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        while (root != null || !stack1.empty()) {
            if (root != null) {
                stack1.push(root);
                stack2.push(root);
                root = root.right;
            } else {
                root = stack1.pop();
                root = root.left;
            }
        }

        while (!stack2.isEmpty()) {
            TreeNode node = stack2.pop();
            System.out.print(node.val + " ");
        }
    }

    public List<Integer> postorder(NAryTreePostorderTraversal.Node root) {
        List<Integer> postOrderTraversal = new ArrayList();

        helperPostOrderTraversal(root, postOrderTraversal);
        return postOrderTraversal;
    }

    /*Iterative technique*/
    private void helperPostOrderTraversal(NAryTreePostorderTraversal.Node root, List<Integer> postOrderTraversal) {
        if (root == null) {
            return;
        }

        Stack<NAryTreePostorderTraversal.Node> stack = new Stack();
        stack.add(root);

        while (!stack.isEmpty()) {
            NAryTreePostorderTraversal.Node current = stack.pop();
            postOrderTraversal.add(current.val);

            if (current.children != null && current.children.size() > 0) {
                for (NAryTreePostorderTraversal.Node child : current.children) {
                    stack.add(child);
                }
            }
        }
        Collections.reverse(postOrderTraversal);
    }
}
