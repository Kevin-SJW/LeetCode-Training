package leetcode;

import java.util.Arrays;

/**
 * @Classname FindFirstAndLastPositionInSortedArray
 * @Description TODO
 * @Date 2019/11/18 16:32
 * @Created by 14241
 */
public class FindFirstAndLastPositionInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        
        System.out.println(Arrays.toString(searchRange(nums,target)));


    }
    public static int[] searchRange(int[] nums, int target){
        int[] targetRange={-1,-1};

        // find the index of the leftmost appearance of `target`.
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                targetRange[0]=i;
                break;
            }
        }
        // if the last loop did not find any index, then there is no valid range
        // and we return [-1, -1].
        if(targetRange[0]==-1){
            return targetRange;
        }
        // find the index of the rightmost appearance of `target` (by reverse
        // iteration). it is guaranteed to appear.
        for(int j=nums.length-1;j>=0;j--){
            if(nums[j]==target){
                targetRange[1]=j;
                break;
            }
        }
        return targetRange;
    }
}
