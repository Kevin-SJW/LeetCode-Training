package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname BinaryTreeInorderTraversal
 * @Description TODO
 * @Date 2020/2/4 14:44
 * @Created by 14241
 */


// Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal tree=new BinaryTreeInorderTraversal();
        TreeNode root=new TreeNode(1);
        int[] a = new int[] {1,0,2,3};
        for (int i : a) {
            tree.add(i,root);
        }

        List<Integer> res=inorderTraversal(root);
        for(int val:res){
            if(val==0){
                continue;
            }
            System.out.print(val+" ");
        }
//        res.stream().forEach(System.out::print);

    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper(root, res);
        return res;
    }

    public static void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
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

}
