package leetcode;

/**
 * @Classname PathSum
 * @Description TODO
 * @Date 2020/2/16 15:42
 * @Created by 14241
 * Given a binary tree and a sum,
 * determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 */
public class PathSum {
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
        int sum = 30;
        System.out.println(hasPathSum(root, sum));

    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return root.val == sum;
        } else {
            sum = sum - root.val;
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }

    }
}
