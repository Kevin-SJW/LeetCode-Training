package leetcode;

/**
 * @Classname RemoveDuplicatesFromSortedArray2
 * @Description TODO
 * @Date 2020/1/21 13:13
 * @Created by 14241
 * Given a sorted array nums,
 * remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));

    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int res=0;
        //记录连续的数个数
        int count =1;
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]){
                count++;
                //大于两次直接跳过
                if(count>2){
                    continue;
                }
            }else{
                //当前数不等于前面的数，重置为1
                count=1;
            }
            nums[res++]=nums[i++];
        }
        return res;
    }
}
