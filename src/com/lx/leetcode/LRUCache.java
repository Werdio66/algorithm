package com.lx.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Werdio丶
 * @since 2021-03-18 20:08:41
 */
public class LRUCache {

    int capacity;

    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)){
            return -1;
        }
        Integer value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)){
            cache.remove(key);
            cache.put(key, value);
            return;
        }
        if (cache.size() == capacity){
            Map.Entry<Integer, Integer> node = cache.entrySet().iterator().next();
            cache.remove(node.getKey());
        }
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 11);
        cache.put(2, 22);
        System.out.println(cache.get(1));
        cache.put(3, 33);
        cache.put(2, 44);
    }
}
