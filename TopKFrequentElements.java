package leetcode;

import java.util.*;

/**
 * @Classname TopKFrequentElements
 * @Description TODO
 * @Date 2020/6/4 15:19
 * @Created by Administrator
 * Given a non-empty array of integers, return the k most frequent elements.
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3};
        int k=2;
        Arrays.stream(topKFrequent(nums, k)).forEach(t-> System.out.print(t+" "));
//        System.out.println(topKFrequent(nums,k).toString());
    }
    public static int[] topKFrequent(int[] nums, int k) {
        if(nums==null||nums.length==0||k<0){
            return new int[]{0};
        }

        int[] res=new int[k];
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.comparingInt(map::get));

        for(int key:map.keySet()){
            if(pq.size()<k){
                pq.add(key);
            }else if(map.get(key)>map.get(pq.size())){
                pq.remove(key);
                pq.add(key);
            }
        }
        for(int i=0;i<res.length;i++){
            res[k-i-1]=pq.poll();
        }
        return res;

    }
}
