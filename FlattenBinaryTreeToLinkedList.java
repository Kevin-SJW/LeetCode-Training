package leetcode;

import java.util.*;

/**
 * @Classname FlattenBinaryTreeToLinkedList
 * @Description TODO
 * @Date 2020/2/17 15:24
 * @Created by 14241
 * 给出一棵树，要求给出这棵树的先序遍历组成的链表，但是还是用树表示。
 * 首先找到根节点左子节点的最右子节点，然后将根节点的右子树移到该点的右节点上；
 * 再将根节点的左子节点移到根节点的右子节点上，
 * 并将根节点左子树重置为null;然后将根节点向右子节点移动一位，递归即可。
 */
public class FlattenBinaryTreeToLinkedList {
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
        List<List<Integer>> res=levelOrder(root);
        printList(res);
        System.out.println();
        flatten(root);

        List<List<Integer>> res2=levelOrder(root);
        printList(res2);

    }
    public static void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
            while(!stack.isEmpty()){
                node.right=stack.peek();
            }
            node.left=null;
        }
    }

    /**
     * 按层次遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            for (TreeNode child : queue) {
                list.add(child.val);
            }
//            TreeNode node=queue.poll();
//            list.add(node.val);
            res.add(list);

            Queue<TreeNode> queue2 = queue;
            queue = new LinkedList<TreeNode>();
            for (TreeNode child : queue2) {
                if (child.left != null) {
                    queue.add(child.left);
                }
                if (child.right != null) {
                    queue.add(child.right);
                }
            }
        }
        return res;

    }

    /**
     * 打印列表
     * @param res
     */
    public static void printList(List<List<Integer>> res){
        for(List<Integer> nums:res){
            for(int nu:nums){
                System.out.print(nu+" ");
            }
        }
    }
}
