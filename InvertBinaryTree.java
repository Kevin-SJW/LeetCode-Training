package leetcode;

/**
 * @Classname InvertBinaryTree
 * @Description TODO
 * @Date 2020/4/6 15:59
 * @Created by 14241
 */
public class InvertBinaryTree {
    public static void main(String[] args) {

    }
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
