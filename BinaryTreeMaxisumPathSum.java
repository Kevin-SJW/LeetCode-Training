package leetcode;

/**
 * @Classname BinaryTreeMaxisumPathSum
 * @Description TODO
 * @Date 2020/2/23 15:15
 * @Created by 14241
 */
public class BinaryTreeMaxisumPathSum {

    public static int maxValue=0;

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        root.left=node1;
        root.right=node2;
        System.out.println(maxPathSum(root));

    }
    public static int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        maxValue=Integer.MIN_VALUE;
        getMaxSum(root);
        return maxValue;

    }

    public static int getMaxSum(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftMax=Math.max(0,getMaxSum(root.left));
        int rightMax=Math.max(0,getMaxSum(root.right));
        maxValue=Math.max(0,root.val+leftMax+rightMax);


        return Math.max(0,root.val+Math.max(leftMax,rightMax));
    }
}
