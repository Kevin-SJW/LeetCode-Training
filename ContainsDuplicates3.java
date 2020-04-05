package leetcode;

import java.util.TreeSet;

/**
 * @Classname ContainsDuplicates3
 * @Description TODO
 * @Date 2020/4/5 14:55
 * @Created by 14241
 * sliding window，用treeset储存k + 1个数,
 * 每次遇到一个新的数，在set里面找离它最近的两个数。
 */
public class ContainsDuplicates3 {
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        int k=3,t=0;
        System.out.println(containsNearbyAlmostDuplicate(nums,k,t));
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        if(len == 0 || k < 1 || t < 0)
            return false;
        TreeSet<Long> S = new TreeSet<>();
        for(int start = 0, end = 0; end < len; end++) {
            Long curr = (long) nums[end];
            Long temp = (long) nums[start];
            if(S.size() >= k + 1) {
                S.remove(temp);
                ++start;
            }
            if(S.contains(curr))
                return true;
            if(S.ceiling(curr) != null)
                if(Math.abs(S.ceiling(curr) - curr) <= t)
                    return true;
            if(S.floor(curr) != null)
                if(Math.abs(S.floor(curr) - curr) <= t)
                    return true;
            S.add(curr);
        }
        return false;
    }
}
