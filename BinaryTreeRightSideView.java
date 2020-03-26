package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname BinaryTreeRightSideView
 * @Description TODO
 * @Date 2020/3/26 15:19
 * @Created by 14241
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(5);
        root.left=node1;
        root.right=node2;
        node1.right=node4;
        node2.right=node3;
        List<Integer> ans=rightSideView(root);
        for(int node:ans){
            System.out.print(node+" ");
        }


    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        addRight(ans,0,root);
        return ans;

    }
    public static void addRight(List<Integer> ans,int high,TreeNode root){
        if(root==null){
            return;
        }
        if(ans.size()==0){
            ans.add(root.val);
        }
        addRight(ans,high+1,root.right);
        addRight(ans,high+1,root.left);
    }

    /**
     * 从上到下打印二叉树（非递归）
     *
     * @param pTreeRoot
     */
    public static ArrayList<Integer> printFromTopToBottom(TreeNode pTreeRoot) { //非递归版本
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (pTreeRoot == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pTreeRoot);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
            list.stream().forEach(System.out::print);
        }
        return list;
    }
}
