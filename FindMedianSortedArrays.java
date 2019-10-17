package leetcode;

/**
 * @Classname FindMedianSortedArrays
 * @Description TODO
 * @Date 2019/10/17 14:24
 * @Created by 14241
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        if (total % 2 == 0) {
            return (findKth(nums1, nums2, total / 2) + findKth(nums1, nums2, total / 2 + 1)) / (2.0);
        } else {
            return findKth(nums1, nums2, total / 2 + 1);
        }
    }

    private static int findKth(int[] num1, int[] num2, int k) {
        int p = 0, q = 0;
        for (int i = 0; i < k - 1; i++) {
            if (p >= num1.length && q <= num2.length) {
                q++;
            } else if (q >= num2.length && p <= num1.length) {
                p++;
            } else if (num1[p] > num2[q]) {
                q++;
            } else {
                p++;
            }
        }
        if (p >= num1.length) {
            return num2[q];
        } else if (q >= num2.length) {
            return num1[p];
        } else {
            return Math.min(num1[p], num2[q]);
        }
    }
}
