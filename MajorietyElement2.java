package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname MajorietyElement2
 * @Description TODO
 * @Date 2020/4/7 15:29
 * @Created by 14241
 * Given an integer array of size n,
 * find all elements that appear more than ⌊ n/3 ⌋ times.
 */
public class MajorietyElement2 {
    public static void main(String[] args) {
        int[] nums={3,2,3};
        System.out.println(majorityElement(nums).toString());

    }
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        if(nums==null){
            return ans;
        }
        int i=0,tmp,len=nums.length;
        Arrays.sort(nums);
        while(i<len-len/3){
            if(nums[i]==nums[i+len/3]){
                tmp=nums[i];
                ans.add(tmp);
                i+=len/3;
                while(i<len-len/3&&nums[i]==tmp){
                    i++;
                }
            }else{
                i++;
            }
        }
        return ans;
    }
}
