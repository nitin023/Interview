package com.cracking.coding.interview.leetcode.topinterview.medium.mix;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
    private final Map<Integer, Node> cacheKeyStoreMap;
    private final Node head;
    private final Node tail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheKeyStoreMap = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cacheKeyStoreMap.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cacheKeyStoreMap.get(key);
        if (node != null) {
            remove(node);
            node.value = value;
        } else {
            if (cacheKeyStoreMap.size() == capacity) {
                cacheKeyStoreMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            node = new Node(key, value);
        }
        add(node);
        cacheKeyStoreMap.put(key, node);
    }

    private void remove(Node node) {
        Node nodeNext = node.next;
        Node nodePrev = node.prev;
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
    }

    private void add(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
