package com.cracking.coding.interview.TreesAndGraphs;

import java.util.*;

public class VerticalOrderTraversal {

    public static class TreeNodeDistance {
        public TreeNode node;
        public int distance;

        TreeNodeDistance(TreeNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {

    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }

        Map<Integer, List<Integer>> sortedDistanceMap = new TreeMap<>();
        getDistanceMap(root, sortedDistanceMap);
        return getList(sortedDistanceMap);

    }

    private static void getDistanceMap(TreeNode root, Map<Integer, List<Integer>> sortedDistanceMap) {
        Queue<TreeNodeDistance> node = new LinkedList();
        TreeNodeDistance rootDistance = new TreeNodeDistance(root, 0);
        node.add(rootDistance);

        while (!node.isEmpty()) {
            TreeNodeDistance currentNode = node.remove();
            TreeNode tmpNode = currentNode.node;
            sortedDistanceMap.putIfAbsent(currentNode.distance, new ArrayList());
            sortedDistanceMap.get(currentNode.distance).add(tmpNode.val);
            if (tmpNode.left != null) {
                node.add(new TreeNodeDistance(tmpNode.left, currentNode.distance - 1));
            }
            if (currentNode.node.right != null) {
                node.add(new TreeNodeDistance(tmpNode.right, currentNode.distance + 1));
            }
        }
    }

    private static List<List<Integer>> getList(Map<Integer, List<Integer>> sortedDistanceMap) {
        List<List<Integer>> response = new ArrayList();
        for (Map.Entry<Integer, List<Integer>> mk : sortedDistanceMap.entrySet()) {
            List<Integer> responseLevel = new ArrayList();
            responseLevel.addAll(mk.getValue());
            response.add(responseLevel);
        }
        return response;
    }
}

