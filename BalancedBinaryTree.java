package leetcode;

/**
 * @Classname BalancedBinaryTree
 * @Description TODO
 * @Date 2020/2/16 15:15
 * @Created by 14241
 * Given a binary tree, determine if it is height-balanced.
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode node1=new TreeNode(9);
        TreeNode node2=new TreeNode(20);
        TreeNode node3=new TreeNode(15);
        TreeNode node4 =new TreeNode(7);
        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node2.right=node4;
        System.out.println(isBalanced(root));

    }
    public static boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }else{
            return (getDepth(root)!=-1);
        }

    }
    public static int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }else{
            int ld=getDepth(root.left);
            int rd=getDepth(root.right);
            if(ld==-1||rd==-1||ld-rd<-1){
                return -1;
            }else{
                return Math.max(ld,rd)+1;
            }
        }

    }
}
