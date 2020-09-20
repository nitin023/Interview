package com.cracking.coding.interview.LinkedList;

/**
 * 2.3 Delete Middle Node
 */
public class DeleteMiddleNode {

    private ListNode deleteMiddleNodeIfHeadIsGiven(ListNode node) {
        if (node == null) {
            return null;
        }

        ListNode iterator = node, prev = null;
        int nodeCount = 0;
        while (iterator != null) {
            nodeCount++;
            iterator = iterator.next;
        }
        int middleNodePos = (int) Math.ceil(nodeCount / 2);
        int currentCtr = 1;
        iterator = node;

        while (iterator != null) {
            if (currentCtr == middleNodePos) {
                //delete at head
                if (currentCtr == 1) {
                    iterator = iterator.next;
                    node = iterator;
                } else {
                    prev.next = iterator.next;
                }
                break;
            }
            prev = iterator;
            iterator = iterator.next;
            currentCtr++;
        }
        return node;
    }

    /**
     * Here only middle node is provided to you
     * So we just know node forward part backward part is not accessible to us
     * but we have to delete the middle node
     * so we begin by copying next elem data to middle node elem
     * then we delete the next node
     * @param listNode middle node
     * @return updated list
     */
    private ListNode deleteMiddleNodeIfOnlyMiddleNodeIsGiven(ListNode listNode) {
        if(listNode == null || listNode.next == null) {return null;}

        ListNode next = listNode.next;
        listNode.val = next.val;
        listNode.next = next.next;
        return listNode;
    }
}

