package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname CombinationSum2
 * @Description TODO
 * @Date 2019/11/30 15:57
 * @Created by 14241
 * 组合总和的升级版。还是想象成图来帮助理解。和第39题相比本题有两个变化。
 * 第一，本题有重复节点；第二，每个节点只能用一次，即没有自环。
 * 结合对39代码注释的理解，稍稍更改即可得到本题的解题思路：
 * 如何处理自环问题？每次搜索新路径的时候都从其下一个节点开始，而不是从它本身开始；
 * <p>
 * 如何处理去重问题？每次回溯的时候，刚刚被剔除的节点不能在任何时候再被重新加入到路径上。
 * 如何处理这个“任何时候”呢？要么用map标记被剔除的节点直到路径搜索结束，要么应用排序，
 * 将所有有相同出权值的节点都放到一起，这样可以方便找到下一个出权值不同的节点。
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target < 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        //排序，使得寻找相同出权值的节点变得容易
        Arrays.sort(candidates);
        get(candidates, target, 0, list, res);
        return res;
    }

    private static void get(int[] candidates, int target, int i, List<Integer> list, List<List<Integer>> res) {
        //因为没有自环，所以每次都是从下一个节点开始搜索，要添加一个条件判断节点仍在图中
        if (i > candidates.length || target < 0) {
            return;
        }
        //满足条件，添加至结果集
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int p = i; p < candidates.length; p++) {
            //添加节点到路径
            list.add(candidates[p]);
            //因为没有自环，所以每次搜索更新路径权值后的下一个节点
            get(candidates, target - candidates[p], p + 1, list, res);
            //回溯，将当前节点从路径中剔除
            list.remove(list.size() - 1);
            //因为存在重复节点，所以已经被剔除的节点不能再被放回到路径中
            while (p < candidates.length - 1 && candidates[p] == candidates[p + 1]) {
                p++;
            }
        }
    }
}
