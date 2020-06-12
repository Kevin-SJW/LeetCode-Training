package leetcode;

import java.util.*;
/**
 * @Classname CreateMaximumNumber
 * @Description TODO
 * @Date 2020/6/12 17:09
 * @Created by Administrator
 * Given two arrays of length m and n with digits 0-9 representing two numbers.
 * Create the maximum number of length k <= m + n from digits of the two.
 * The relative order of the digits from the same array must be preserved.
 * Return an array of the k digits.
 *
 */
public class CreateMaximumNumber {
    public static void main(String[] args) {
        int[] nums1={3, 4, 6, 5};
        int[] nums2={9, 1, 2, 5, 8, 3};
        int k=5;
        Arrays.stream(maxNumber(nums1, nums2, k)).forEach(t-> System.out.print(t+" "));
//        System.out.println(maxNumber(nums1,nums2,k).toString());
//
e
    }
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for(int i= Math.max(0, k-m); i<=k && i <= n ; i++){
            int[] candidate = merge(maxArray(nums1,i), maxArray(nums2, k-i), k);
            if(greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
    }

    public static int[] merge(int[] nums1, int[] nums2, int k){
        int[] ans = new int[k];
        for(int i=0, j=0, r=0; r<k; r++){
            ans[r] = greater(nums1,i,nums2,j) ? nums1[i++] : nums2[j++];
        }
        return ans;
    }

    public static boolean greater(int[] nums1, int i, int[] nums2, int j){
        while(i< nums1.length && j < nums2.length && nums1[i] == nums2[j]){
            i++;
            j++;
        }
        return j == nums2.length || (i<nums1.length && nums1[i] > nums2[j]);
    }

    public static int[] maxArray(int[] nums, int k){
        int n = nums.length;
        int[] ans = new int[k];
        for(int i=0, j=0; i < n; i++){
            while(n-i> k-j && j > 0 && nums[i] > ans[j-1]) j--;
            if(j<k) ans[j++] = nums[i];
        }
        return ans;
    }
}
