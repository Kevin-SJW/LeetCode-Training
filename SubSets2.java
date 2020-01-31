package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname SubSets2
 * @Description TODO
 * @Date 2020/1/31 14:45
 * @Created by 14241
 * Given a collection of integers that might contain duplicates,
 * nums, return all possible subsets (the power set).
 */
public class SubSets2 {
    public static void main(String[] args) {
        int[] nums={1,2,2};
        System.out.println(subsetsWithDup(nums));

    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums.length==0){
            return res;
        }
        Arrays.sort(nums);
        int index=0;
        ArrayList<Integer> list=new ArrayList<Integer>();
        res.add(list);
        for(int i=0;i<nums.length;i++){
            int size=res.size();
            for(int j=index;j<size;j++){
                list=new ArrayList<Integer>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
            if(i<nums.length-1&&nums[i]==nums[i+1]){
                index=size;
            }else{
                index=0;
            }
        }
        return res;
    }
}
