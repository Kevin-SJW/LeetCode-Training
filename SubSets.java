package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SubSets
 * @Description TODO
 * @Date 2020/1/20 18:28
 * @Created by 14241
 * Given a set of distinct integers, nums,
 * return all possible subsets (the power set).
 */
public class SubSets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int num : nums) {
            //这里要注意，必须提前把size提取出来，不能把提取过程直接嵌入到下面的for语句中
            //因为res的size会在下面语句中一直变化
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> copyItem = new ArrayList<>(res.get(i));
                copyItem.add(num);
                res.add(copyItem);
            }

        }
        return res;
    }
}
