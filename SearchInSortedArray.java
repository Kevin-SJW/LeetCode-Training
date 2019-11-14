package leetcode;

/**
 * @Classname SearchInSortedArray
 * @Description TODO
 * @Date 2019/11/14 15:04
 * @Created by 14241
 */
public class SearchInSortedArray {
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {
            return search(nums,0,nums.length-1,target);
    }

    private static int search(int[] nums,int low,int high,int target){
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(nums[mid]==target){
            return mid;
        }
        //后半部分有序
        if(nums[mid]<nums[high]){
            //在有序部分，则继续二分此部分
            if(nums[mid]<target&&target<=nums[high]){
                return search(nums,mid+1,high,target);
            }else{
                return search(nums,low,mid-1,target);
            }
        //前半部分有序
        }else{
            //在有序部分，则继续二分此部分
            if(nums[low]<target&&target<nums[mid]){
                return search(nums,low,mid-1,target);
            }else{
                return search(nums,mid+1,high,target);
            }
        }
    }
}
