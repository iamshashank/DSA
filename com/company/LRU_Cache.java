package com.company;

import java.util.HashMap;

/**
 *
 * O(1) O(1) read write
 * 146. LRU Cache
 * Medium
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 *     LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 *     int get(int key) Return the value of the key if the key exists, otherwise return -1.
 *     void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 *
 * The functions get and put must each run in O(1) average time complexity.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 *
 *
 * Constraints:
 *
 *     1 <= capacity <= 3000
 *     0 <= key <= 104
 *     0 <= value <= 105
 *     At most 2 * 105 calls will be made to get and put.
 *
 */


public class LRU_Cache {
    class LRUCache {
        HashMap<Integer, CacheItem> map;
        int cap;
        CacheItem root = null, tail = null;
        public LRUCache(int capacity) {
            map = new HashMap<>();
            cap = capacity;
        }

        public int get(int key) {
            CacheItem node = map.getOrDefault(key, null);
            if(node == null){
                return -1;
            }else{
                if(node == root && node == tail){
                    // only 1 el
                    return node.val;
                }else if(node == root){
                    return node.val;
                }else if(node != tail){
                    CacheItem t = node.prev;
                    t.next = node.next;
                    node.next.prev = t;
                    node.prev = null;
                    node.next = null;
                }else{
                    tail = node.prev;
                    tail.next = null;
                    node.next = null;
                    node.prev = null;
                }
            }
            // CacheItem tRoot = root;
            node.next = root;
            root.prev = node;
            root = node;
            return root.val;
        }

        public void put(int key, int value) {
            if(root == null){
                root = new CacheItem(key, value);
                map.put(key, root);
                tail = root;
                return;
            }
            CacheItem node = map.getOrDefault(key, null);
            if(node == null){
                node = new CacheItem(key, value);
                map.put(key, node);
            }else{
                node.setValue(value);
                if(node == root && node == tail){
                    // only 1 item
                    return;
                }else if(node == root){
                    return;
                }else if(node != tail){
                    CacheItem t = node.prev;
                    t.next = node.next;
                    node.next.prev = t;
                    node.prev = null;
                    node.next = null;
                }else{
                    tail = node.prev;
                    tail.next = null;
                    node.next = null;
                    node.prev = null;
                }
            }
            // CacheItem tRoot = root;
            node.next = root;
            root.prev = node;
            root = node;
            if(map.size() > cap){
                // remnove tail
                map.remove(tail.key);
                CacheItem t = tail;
                tail = tail.prev;
                tail.next = null;
                t.prev = null;
                t.next = null;
            }
        }

        class CacheItem{
            public int key, val;
            public CacheItem prev = null, next = null;
            CacheItem(int key, int val){
                this.key = key;
                this.val = val;
            }

            public void setValue(int value){
                this.val = value;
            }
        }
    }
}
