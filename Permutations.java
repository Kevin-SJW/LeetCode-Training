package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Permutations
 * @Description TODO
 * @Date 2019/12/9 14:52
 * @Created by 14241
 * Given a collection of distinct integers, return all possible permutations.
 */
public class Permutations {
    public static List<List<Integer>> result = null;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return result;
        }
        result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>());
        return result;


    }

    public static void dfs(int[] nums, int start, List<Integer> list) {
        if (start==nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs(nums, start + 1, list);
                list.remove(list.size() - 1);
            }
        }

    }
}
