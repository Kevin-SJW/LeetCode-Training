package leetcode;

/**
 * @Classname FindPeakElement
 * @Description TODO
 * @Date 2020/3/16 15:33
 * @Created by 14241
 * A peak element is an element that is greater than its neighbors.
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(findPeakElement(nums));

    }
    public static int findPeakElement(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]>nums[mid+1]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}
