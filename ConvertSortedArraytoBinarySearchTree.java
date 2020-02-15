package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname ConvertSortedArraytoBinarySearchTree
 * @Description TODO
 * @Date 2020/2/15 15:17
 * @Created by 14241
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class ConvertSortedArraytoBinarySearchTree {
    public static void main(String[] args) {
        int[] nums={-10,-3,0,5,9};

        List<List<Integer>> res=new ArrayList<>();
        res=levelOrder(sortedArrayToBST(nums));
        for (List<Integer> re : res) {
            for (int num : re) {
                System.out.print(num + " ");
            }
        }


    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length-1);

    }
    public static TreeNode buildTree(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=buildTree(nums,start,mid-1);
        root.right=buildTree(nums,mid+1,end);
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
