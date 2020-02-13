package leetcode;

import java.util.*;

/**
 * @Classname ConstructBinaryTreeFromPreorderandInoderTraversal
 * @Description TODO
 * @Date 2020/2/13 14:57
 * @Created by 14241
 */
public class ConstructBinaryTreeFromPreorderandInoderTraversal {
    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode nodes = buildTree(preorder, inorder);
        List<List<Integer>> res = levelOrder(nodes);
        for (List<Integer> list : res) {
            for (int num : list) {
                System.out.print(num + " ");
            }
        }


    }

    /**
     * 按前序和中序构建二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    static int preIndex = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return btHelper(preorder, map, 0, inorder.length - 1);


    }

    private static TreeNode btHelper(int[] preorder, Map<Integer, Integer> map, int start, int end) {

        if (start > end) return null;
        //由先序遍历数组可以很容易的得到根结点的值
        TreeNode root = new TreeNode(preorder[preIndex++]);

        //index 是当前子树的根结点的索引，由此可以得到左右子树的索引范围，从而进行递归
        int index = map.get(root.val);

        root.left = btHelper(preorder, map, start, index - 1);
        root.right = btHelper(preorder, map, index + 1, end);

        return root;

    }


    /**
     * 按层次遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            for (TreeNode child : queue) {
                list.add(child.val);
            }
//            TreeNode node=queue.poll();
//            list.add(node.val);
            res.add(list);

            Queue<TreeNode> queue2 = queue;
            queue = new LinkedList<TreeNode>();
            for (TreeNode child : queue2) {
                if (child.left != null) {
                    queue.add(child.left);
                }
                if (child.right != null) {
                    queue.add(child.right);
                }
            }
        }
        return res;

    }
}
