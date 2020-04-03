package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname CombinationSum3
 * @Description TODO
 * @Date 2020/4/3 14:58
 * @Created by 14241
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        int k=3,n=7;
        List<List<Integer>> ans=combinationSum3(k,n);
        ans.stream().forEach(
                comb->comb.forEach(
                        t->System.out.print(t+" ")));

    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> comb=new ArrayList<>();
        helper(ans,comb,k,1,n);
        return ans;

    }

    public static void helper(List<List<Integer>> ans,List<Integer> comb,int k,int i_th,int rest){
        if(comb.size()>k||rest<0){
            return;
        }
        if(comb.size()==k&&rest==0){
            List<Integer> temp=new ArrayList<>(comb);
            ans.add(temp);
            return;
        }
        for(int i=i_th;i<=9;i++){
            comb.add(i);
            helper(ans,comb,k,i+1,rest-i);
            comb.remove(comb.size()-1);
        }
    }
}
