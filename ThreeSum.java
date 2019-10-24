package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname ThreeSum
 * @Description TODO
 * @Date 2019/10/24 14:16
 * @Created by 14241
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res=threeSum(nums);
        System.out.println(res);

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        Arrays.sort(nums);

        for(int k=0;k<nums.length-2;k++){
            int i=k+1;
            int j=nums.length-1;
            int target=0-nums[k];
            while(i<j){
                if(target==nums[i]+nums[j]){
                    lists.add(Arrays.asList(nums[k],nums[i++],nums[j--]));
                    while(i<j&&nums[i]==nums[i-1]){
                        i++;
                    }
                    while(i<j&&nums[j]==nums[j+1]){
                        j--;
                    }

                }else if(nums[k]+nums[i]+nums[j]<target){
                    i++;
                }else{
                    j--;
                }
            }
            //防止重复
                while(k==nums.length-2||nums[k]==nums[k+1]){
                    k++;
                }
        }
        return lists;
    }
}
