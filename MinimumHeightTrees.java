package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname MinimumHeightTrees
 * @Description TODO
 * @Date 2020/6/5 17:09
 * @Created by Administrator
 */
public class MinimumHeightTrees {
    public static void main(String[] args) {

    }
    public static List<Integer> findMinHeightTrees(int n, int[][] edges){
        List<Integer> leaves=new ArrayList<>();
        if(n==1){
            leaves.add(0);
            return leaves;
        }
        List<Set<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new HashSet<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for(int i = 0; i < n; i++)
            if(adj.get(i).size()==1) leaves.add(i);
        while(n > 2){
            n-=leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int i : leaves){
                for(int j : adj.get(i)){
                    adj.get(j).remove(i);
                    if(adj.get(j).size() ==1) newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;

    }
}
