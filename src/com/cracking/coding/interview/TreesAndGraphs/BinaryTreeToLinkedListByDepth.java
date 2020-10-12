package com.cracking.coding.interview.TreesAndGraphs;

import com.cracking.coding.interview.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeToLinkedListByDepth {
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }

        List<List<Integer>> listLevel = getLevelList(root);

        List<ListNode> LinkedList = new ArrayList();

        for (List<Integer> tmp : listLevel) {
            ListNode linkedNode = null;

            for (int item : tmp) {
                if (linkedNode == null) {
                    linkedNode = new ListNode(item);
                } else {
                    linkedNode.next = new ListNode(item);
                }
            }
            LinkedList.add(linkedNode);
        }
        return LinkedList;
    }

    private List<List<Integer>> getLevelList(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        List<List<Integer>> listLevel = new ArrayList();
        List<Integer> tmpList = new ArrayList();
        while (true) {
            int nodeCount = queue.size();
            if (nodeCount == 0) {
                break;
            }
            tmpList = new ArrayList();
            while (nodeCount > 0) {
                nodeCount--;
                TreeNode node = queue.poll();
                tmpList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            listLevel.add(tmpList);
        }

        return listLevel;
    }
}
