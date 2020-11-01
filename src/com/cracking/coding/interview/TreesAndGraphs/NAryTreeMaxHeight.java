package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class NAryTreeMaxHeight {

    public static void main(String[] args) {
        List<NAryTreePostorderTraversal.Node> childrens = new ArrayList<>();
        List<NAryTreePostorderTraversal.Node> childrens1 = new ArrayList<>();
        childrens1.add(new NAryTreePostorderTraversal.Node(5,new ArrayList<>()));
        childrens1.add(new NAryTreePostorderTraversal.Node(6,new ArrayList<>()));
        childrens.add(new NAryTreePostorderTraversal.Node(3,childrens1));
        childrens.add(new NAryTreePostorderTraversal.Node(2,new ArrayList<>()));
        childrens.add(new NAryTreePostorderTraversal.Node(4,new ArrayList<>()));
        NAryTreePostorderTraversal.Node node = new NAryTreePostorderTraversal.Node(1,childrens);


        System.out.println(maxDepth(node));
    }
    public static int maxDepth(NAryTreePostorderTraversal.Node root) {
        return helperMaxDepth(root);
    }

    private static int helperMaxDepth(NAryTreePostorderTraversal.Node root) {
        if (root == null) {
            return 0;
        }
        int maxHeight = 0;
        for (NAryTreePostorderTraversal.Node children : root.children) {
            maxHeight = Integer.max(helperMaxDepth(children),maxHeight);
        }
        return maxHeight+1;
    }
}
