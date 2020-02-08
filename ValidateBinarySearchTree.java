package leetcode;

import java.util.Stack;

/**
 * @Classname ValidateBinarySearchTree
 * @Description TODO
 * @Date 2020/2/8 15:12
 * @Created by 14241
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        int[] tree={2,1,3};
        ValidateBinarySearchTree node=new ValidateBinarySearchTree();
        TreeNode root=new TreeNode(2);
        node.add(2,root);
        node.add(1,root);
        node.add(3,root);
        System.out.println(isValidBST(root));


    }

    /**
     * 验证二叉搜索树
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s=new Stack<>();
        TreeNode p=root,pre=null;
        while(p!=null||!s.isEmpty()){
            while(p!=null){
                s.push(p);
                p=p.left;
            }
            p=s.pop();
            if(pre!=null&&pre.val>=p.val){
                return false;
            }
            pre=p;
            p=p.right;
        }
        return true;
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
