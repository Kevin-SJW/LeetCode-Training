package leetcode;

import java.util.*;

/**
 * @Classname ConstructBinaryTreeFromInorderAndPostorderTraversal
 * @Description TODO
 * @Date 2020/2/14 15:07
 * @Created by 14241
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {9,3,15,20,7};
        int[] inorder = {9,15,7,20,3};
        TreeNode nodes = buildTree(preorder, inorder);
        List<List<Integer>> res = levelOrder(nodes);
        for (List<Integer> list : res) {
            for (int num : list) {
                System.out.print(num + " ");
            }
        }

    }
    public static TreeNode buildTree(int[] inorder, int[] postorder)
    {
        if(inorder==null || postorder==null || inorder.length==0 || postorder.length==0)
            return null;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(inorder,postorder,0,inorder.length-1, 0, postorder.length-1,map);
    }
    private static TreeNode helper(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR, HashMap<Integer, Integer> map)
    {
        if(inL>inR || postL>postR)
            return null;
        TreeNode root = new TreeNode(postorder[postR]);
        int index = map.get(root.val);
        root.left = helper(inorder,postorder,inL,index-1,postL,postL+index-inL-1,map);
        root.right = helper(inorder,postorder,index+1,inR,postR-(inR-index),postR-1,map);
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
