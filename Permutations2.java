package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Permutations2
 * @Description TODO
 * @Date 2019/12/11 14:29
 * @Created by 14241
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 * <p>
 * 这里采用了递归的思路。避免重复的核心思路在于，
 * 使用一个boolean数组来代表当前的数值是否已经被使用过。
 * 当前的值如果已经被使用过，则继续判断下一个数值。如果当前的值为重复值，
 * 则只要前面的值没有被使用过，则当前值就不可以被使用。
 * 这样确保了只有第一个出现的重复值可以算进结果集，后序重复的情况不会被添加进结果集。
 * 例如，假设输入的数组为[1，1，2]。则当第一个1被添加进结果集时，
 * 可以继续使用第二个1作为元素添加进结果集从而生成112。
 * 同理，当试图将第二个1作为第一个元素添加进结果集时，
 * 只要第一个1还没有被使用过，则不可以使用第二个1。因此，112不会被重复的添加进结果集。
 * 其实，这个算法保证了所有重复的数字在结果集中的顺序和在原输入数组中的顺序是相同的。
 * 假设将[1,1,2]表示为[1,1#,2],那么结果集中会确保1永远在数值1#的前面，
 * 从而避免了11#2和1#12的重复情况出现。
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Permutations2 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        //排序有利于判断重复值
        Arrays.sort(nums);
        //深度优先算法
        dfs(nums, used, list, res);
        return res;
    }

    public static void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        //如果结果长度和输入长度相等，则添加进结果集
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果该元素已经被使用过，则继续遍历
            if (used[i]) {
                continue;
            }
            //下一个重复值只有在前一个重复值被使用的情况下才可以使用
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, res);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
