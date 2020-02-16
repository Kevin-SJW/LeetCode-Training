package leetcode;

/**
 * @Classname MinimumDepthOfBinaryTree
 * @Description TODO
 * @Date 2020/2/16 15:33
 * @Created by 14241
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes
 * along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {
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
        System.out.println(minDepth(root));
    }
    public static int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        if(left==0){
            return right+1;
        }
        if(right==0){
            return left+1;
        }
        return Math.min(left,right)+1;
    }
}
