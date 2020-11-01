package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Easy
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        return getLevelsAverage(root);
    }

    private List<Double> getLevelsAverage(TreeNode root) {
        List<Double> _averageOfLevels = new ArrayList();

        Queue<TreeNode> levelQueue = new LinkedList();
        levelQueue.add(root);

        int queueSize, count;
        while (!levelQueue.isEmpty()) {
            count = queueSize = levelQueue.size();
            List<Integer> _levelTrav = new ArrayList();
            double sum = 0;
            while (queueSize > 0) {
                TreeNode node = levelQueue.poll();
                sum += (node.val);
                if (node.left != null) {
                    levelQueue.add(node.left);
                }
                if (node.right != null) {
                    levelQueue.add(node.right);
                }
                queueSize--;
            }
            _averageOfLevels.add(sum / count);
        }
        return _averageOfLevels;
    }
}
