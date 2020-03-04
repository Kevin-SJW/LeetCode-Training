package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname SingleNumber
 * @Description TODO
 * @Date 2020/3/4 15:27
 * @Created by 14241
 * Given a non-empty array of integers, every element appears twice except for one.
 * Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums={4,1,2,1,2};
        System.out.println(singleNumber(nums));

    }
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
            i++;
        }
        i=0;
        while(i<=j){
            if(map.get(nums[i])==1){
                break;
            }else{
                i++;
            }
        }
        return nums[i];

    }
}
