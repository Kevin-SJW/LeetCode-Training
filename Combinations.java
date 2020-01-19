package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Combinations
 * @Description TODO
 * @Date 2020/1/19 13:15
 * @Created by 14241
 * Given two integers n and k,
 * return all possible combinations of k numbers out of 1 ... n.
 */
public class Combinations {
    public static void main(String[] args) {
        int n=4,k=2;
        System.out.println(combine(n,k));

    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> tmp=new ArrayList<>();
        dfs(res,tmp,n,k,1);
        return res;
    }

    public static void dfs(List<List<Integer>> res,List<Integer> tmp,int n,int k,int m){
        if(k==0){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i=m;i<=n;i++){
            tmp.add(i);
            dfs(res,tmp,n,k-1,i+1);
            tmp.remove(tmp.size()-1);
        }

    }
}
