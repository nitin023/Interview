package com.cracking.coding.interview.TreesAndGraphs;

import java.util.*;

public class HasRoute {
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {

        if (graph == null || s == null || t == null) {
            return false;
        }

        if (s == t) {
            return true;
        }
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        queue.add(s);
        Set<DirectedGraphNode> visitedNodes = new HashSet();

        while (!queue.isEmpty()) {
            DirectedGraphNode currentNode = queue.poll();
            visitedNodes.add(currentNode);

            for (DirectedGraphNode neighbour : currentNode.neighbors) {
                if (t == neighbour) {
                    return true;
                }
                if (!visitedNodes.contains(neighbour)) {
                    queue.add(neighbour);
                }
            }
        }

        return false;
    }
}
