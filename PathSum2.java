package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PathSum2
 * @Description TODO
 * @Date 2020/2/17 14:49
 * @Created by 14241
 * Given a binary tree and a sum,
 * find all root-to-leaf paths where each path's sum equals the given sum.
 */
public class PathSum2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        int sum=30;
        List<List<Integer>> res=pathSum(root,sum);
        for(List<Integer> nums:res){
            for(int num:nums){
                System.out.print(num+" ");
            }
        }

    }

    /**
     * 求二叉树路径和并记录和为定值的路径
     * @param root
     * @param sum
     * @return
     */
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(res, list, root, sum);
        return res;

    }

    public static void backTrack(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && root.val==sum) {
            res.add(new ArrayList<>(list));
        } else {
            backTrack(res, list, root.left, sum - root.val);
            backTrack(res, list, root.right, sum - root.val);
        }

        list.remove(list.size() - 1);
    }
}
