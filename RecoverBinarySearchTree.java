package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname RecoverBinarySearchTree
 * @Description TODO
 * @Date 2020/2/9 15:04
 * @Created by 14241
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 */
public class RecoverBinarySearchTree {

    private static TreeNode first=null,second;
    private static TreeNode prev=new TreeNode(Integer.MIN_VALUE);

    public static void main(String[] args) {
        RecoverBinarySearchTree node= new RecoverBinarySearchTree();
        TreeNode root=new TreeNode(1);
        String s=null;
        node.add(1,root);
        node.add(3,root);
        node.add(0,root);
        node.add(0,root);
        node.add(2,root);
        recoverTree(root);
        printFromTopToBottom(root);

    }

    /**
     * 重建树
     * @param root
     */
    public static void recoverTree(TreeNode root) {
        if(root==null){
            return;
        }
        traverse(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;

    }

    /**
     * 遍历
     * @param root
     */
    public static void traverse(TreeNode root){
        if(root==null){
            return;
        }
        traverse(root.left);

        while(first!=null&&prev.val<root.val){
            first=prev;
        }
        while(first==null&&prev.val<root.val){
            second=root;
        }
        prev=root;
        traverse(root.right);
    }

    /**
     * 添加节点
     * @param val
     */
    public boolean add(int val,TreeNode root){
        //创建新节点对象
        TreeNode node = new TreeNode(val);
//        TreeNode root=new TreeNode(val);
        //根结点不存在
        if(root==null) {
            root = node;
            return true;
        }else {
            TreeNode cur = root;
            while(true) {
                if(val < cur.val) {
                    if(cur.left == null) {
                        TreeNode newNode = new TreeNode(val);
                        cur.left = newNode;
                        return true;
                    }
                    cur = cur.left;
                }else if(val > cur.val){
                    if(val > cur.val) {
                        if(cur.right == null) {
                            TreeNode newNode = new TreeNode(val);
                            cur.right = newNode;
                            return true;
                        }
                        cur = cur.right;
                    }
                }else {
                    //不允许重复
                    return false;
                }

            }
        }
    }
    /**
     * 从上到下打印二叉树（非递归）
     * @param pTreeRoot
     */
    public static ArrayList<Integer> printFromTopToBottom(TreeNode pTreeRoot){ //非递归版本
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(pTreeRoot == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pTreeRoot);
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
            list.stream().forEach(System.out::print);
        }
        return list;
    }
}
