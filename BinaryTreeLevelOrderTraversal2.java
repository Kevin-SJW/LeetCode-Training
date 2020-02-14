package leetcode;

import java.util.*;

/**
 * @Classname BinaryTreeLevelOrderTraversal2
 * @Description TODO
 * @Date 2020/2/14 15:14
 * @Created by 14241
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 */
public class BinaryTreeLevelOrderTraversal2 {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal2 node =new BinaryTreeLevelOrderTraversal2();
        TreeNode root = new TreeNode(3);
        TreeNode node1=new TreeNode(9);
        TreeNode node2=new TreeNode(20);
        TreeNode node3=new TreeNode(15);
        TreeNode node4=new TreeNode(7);
        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node2.right=node4;
        List<List<Integer>> res = levelOrderBottom(root);
        for (List<Integer> re : res) {
            for (int num : re) {
                System.out.print(num + " ");
            }
        }

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 当前处理的节点
        TreeNode curNode;

        while (!queue.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            // 遍历本层元素, 并把结果加入返回列表中
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                curNode = queue.poll();
                // 当前值入列表
                curList.add(curNode.val);
                // 下层元素入队列
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }

            }
            // 当前层元素加入待返回列表
            res.add(curList);

        }
        Collections.reverse(res);
        return res;
    }
}
