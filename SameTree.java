package leetcode;

/**
 * @Classname SameTree
 * @Description TODO
 * @Date 2020/2/10 15:37
 * @Created by 14241
 * Given two binary trees, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical
 * <p>
 * and the nodes have the same value.
 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(0);
        TreeNode node2=new TreeNode(1);
        System.out.println(isSameTree(node1,node2));;


    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (q == null || p == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
