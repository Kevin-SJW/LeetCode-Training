package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Classname LRUCache
 * @Description TODO
 * @Date 2020/3/9 15:45
 * @Created by 14241
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;

    }

    public int get(int key) {
        return super.getOrDefault(key, -1);

    }

    public void put(int key, int value) {
        super.put(key, value);

    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return size()>capacity;
    }

    public static void main(String[] args) {
        LRUCache cache=new LRUCache(50);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */