package leetcode;


import java.util.Arrays;

/**
 * @Classname KthLargestElementInAnArray
 * @Description TODO
 * @Date 2020/4/2 16:00
 * @Created by 14241
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * 题意：给出一个无序排列的数组，找出其中第k大的元素。数组中可能有重复元素，
 * 但是这里第K大就是指 倒数第k个数，不管其中有没有重复的元素。所以，只需要对数组排序然后从后往前找就行。
 *
 *
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums={3,2,1,5,6,4};
        int k=2;
        System.out.println(findKthLargest(nums,k));

    }
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i=nums.length-1;i>0;i--){
            if(k==1){
                return nums[i];
            }else{
                k--;
            }
        }
        return nums[0];

    }
}
