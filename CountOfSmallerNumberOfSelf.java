package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname CountOfSmallerNumberOfSelf
 * @Description TODO
 * @Date 2020/4/29 15:22
 * @Created by 14241
 */
public class CountOfSmallerNumberOfSelf {
    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        List<Integer> result = countSmaller(nums);
        for(Integer value : result){
            System.out.print(value + " ");
        }

    }

    public static List<Integer> countSmaller(int[] nums) {
        if (nums == null) {
            return new ArrayList<Integer>();
        }
        Integer[] result = new Integer[nums.length];
        //对已经遍历的右边的数值进行升序存储，找到当前数值应该放入的位置，即是它右边有几个比它小的个数
        int mid, left, right;
        List<Integer> sort = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            left = 0;
            right = sort.size();
            //二分法查到当前数值的排序位置，即当前数值的右边有几个比它小的个数
            while (left < right) {
                mid = left + (right - left) / 2;

                if (sort.get(mid) >= nums[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            }
            result[i] = left;
            sort.add(left, nums[i]);

        }
        return  Arrays.asList(result);
    }
}
