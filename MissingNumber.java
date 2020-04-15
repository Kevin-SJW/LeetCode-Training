package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname MissingNumber
 * @Description TODO
 * @Date 2020/4/15 15:47
 * @Created by 14241
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums={3,0,1};
        System.out.println(missingNumber(nums));

    }
    public static int missingNumber(int[] nums) {
        Set<Integer> numSet=new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        int len=nums.length+1;
        for(int i=0;i<len;i++){
            if(!numSet.contains(i)){
                return i;
            }
        }
        return -1;
    }
}
